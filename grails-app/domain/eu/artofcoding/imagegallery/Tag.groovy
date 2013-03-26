/*
 * ImageGallery
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

package eu.artofcoding.imagegallery

/**
 * A tag.
 */
class Tag {

    Long id
    Long version
    Date dateCreated
    Date lastUpdated

    String name

    static constraints = {
        name nullable: false
    }

}
