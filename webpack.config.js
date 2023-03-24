const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const env = process.env.NODE_ENV || 'development';
const isDevelopment = env === 'development';

module.exports = {
  mode: env,
  devtool: isDevelopment ? 'source-map' : false,
  devServer: {
    static: {
      directory: path.join(__dirname, 'public'),
    },
    compress: true,
    port: 9000,
  },
  entry: './index.js',
  output: {
    path: __dirname + '/public',
    filename: 'bundle.js',
  },
  resolve: {
    extensions: ['.ts', '.tsx', '.js'],
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          {
            loader: 'babel-loader',
            options: {
              presets: ['@babel/preset-env'],
            },
          },
        ],
      },
      {
        test: /\.tsx?$/,
        loader: 'ts-loader',
      },
    ],
  },
  target: ['web', 'es5'],
  plugins: [
    new HtmlWebpackPlugin({
      template: 'index.html',
    }),
  ],
};
