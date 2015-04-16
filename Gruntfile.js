module.exports = function(grunt) {
  'use strict';

  require('load-grunt-tasks')(grunt);

  grunt.initConfig({

    'bower-install-simple': {
      all: {
        // all defaults
      },
    },

    connect: {
      talk: {
        options: {
          port: 8088,
          open: 'http://localhost:8088/talk/',
          livereload: true,
        },
      },
    },

    watch: {
      talk: {
        files: ['talk/*.html'],
        options: {
          livereload: true,
        },
      },
    },

  });

  grunt.registerTask('serve', [
    'connect:talk',
    'watch:talk'
  ]);

  grunt.registerTask('default', ['serve']);

};
