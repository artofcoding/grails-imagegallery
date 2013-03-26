/*
 * ImageGallery
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

import eu.artofcoding.imagegallery.ContestConfig
import eu.artofcoding.imagegallery.ContestFileType
import eu.artofcoding.imagegallery.ImageGalleryConfig

/**
 * @author rbe
 */
class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        // Common file types for images
        ['gif', 'jpg', 'jpeg', 'png', 'tif', 'tiff'].each {
            ContestFileType ft = ContestFileType.findByName(it)
            if (!ft) {
                ft = new ContestFileType(name: it)
                ft.save()
            }
        }
        // Add a contest for testing
        ['smiling_faces', 'dumb_ears'].each {
            ContestConfig cc = ContestConfig.findByContest(it)
            if (!cc) {
                cc = new ContestConfig(contest: it)
                ContestFileType.list().each { ft -> cc.addToFileTypes(ft) }
                cc.save()
                println "Created config: ${cc.dump()}"
            }
        }
        // Set actual contest
        ImageGalleryConfig fc = ImageGalleryConfig.findById(1)
        if (!fc) {
            fc = new ImageGalleryConfig(
                    imageMagickHome: '/Users/rbe/app/ImageMagick/6.7.4',
                    uploadDirectory: 'temp/smiling_faces'
            )
            fc.save()
        }
        // Ready.
        println "ImageGallery - STARTED."
    }

    def destroy = {
        // Ready.
        println "ImageGallery - STOPPED."
    }

}
