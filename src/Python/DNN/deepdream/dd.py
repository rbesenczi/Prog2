import tensorflow as tf
import numpy as np
from tensorflow.keras.preprocessing import image
import ddfunctions as dd

import argparse

physical_devices = tf.config.experimental.list_physical_devices('GPU')
assert len(physical_devices) > 0, "Not enough GPU hardware devices available"
tf.config.experimental.set_memory_growth(physical_devices[0], True)

def main():
  parser = argparse.ArgumentParser(description='Process some integers.')
  parser.add_argument('input_filename', help='The name of the input file.')
  parser.add_argument('output_filename', help='The name of the output file.')
  parser.add_argument('layer1_id', help='ID of the first layer (max 9)')
  parser.add_argument('layer2_id', help='ID of the second layer (max 10)')
  args = parser.parse_args()

  original_img = dd.open(args.input_filename, max_dim=500)

  base_model = tf.keras.applications.InceptionV3(include_top=False, weights='imagenet')

  # Maximize the activations of these layers
  names = ['mixed' + args.layer1_id, 'mixed' + args.layer2_id]
  layers = [base_model.get_layer(name).output for name in names]

  # Create the feature extraction model
  dream_model = tf.keras.Model(inputs=base_model.input, outputs=layers)

  OCTAVE_SCALE = 1.30

  img = tf.constant(np.array(original_img))
  base_shape = tf.shape(img)[:-1]
  float_base_shape = tf.cast(base_shape, tf.float32)

  img = tf.image.resize(img, base_shape)
  img = tf.image.convert_image_dtype(img/255.0, dtype=tf.uint8)

  shift_down, shift_right, img_rolled = dd.random_roll(np.array(original_img), 512)

  dd.get_tiled_gradients = dd.TiledGradients(dream_model)

  img = dd.run_deep_dream_with_octaves(img=original_img, step_size=0.01)

  img = tf.image.resize(img, base_shape)
  img = tf.image.convert_image_dtype(img/255.0, dtype=tf.uint8)
  dd.save(img, args.output_filename)

if __name__ == "__main__":
    main()
