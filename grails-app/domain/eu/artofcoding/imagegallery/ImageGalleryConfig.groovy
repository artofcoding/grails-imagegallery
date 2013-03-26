/*
 * ImageGallery
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

package eu.artofcoding.imagegallery

/**
 * @author rbe
 */
class ImageGalleryConfig {

    Long id
    Long version
    Date dateCreated
    Date lastUpdated

    String imageMagickHome
    String uploadDirectory

    static constraints = {
        imageMagickHome nullable: false
        uploadDirectory nullable: false
    }

}
