/*
 * ImageGallery
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

package eu.artofcoding.imagegallery

/**
 * Configuration of contest.
 * @author rbe
 */
class ContestConfig {

    Long id
    Long version
    Date dateCreated
    Date lastUpdated

    String contest
    Long maximumFileSize
    Integer maximumWidth
    Integer maximumHeight
    Integer standardThumbnailHeight
    String uploadDirectory

    static hasMany = [fileTypes: ContestFileType]

    static constraints = {
        contest nullable: false
        //fileTypes nullable: false
        maximumFileSize nullable: true
        maximumWidth nullable: true
        maximumHeight nullable: true
        standardThumbnailHeight nullable: true
        uploadDirectory nullable: true
    }

    def beforeInsert() {
        if (!maximumFileSize) maximumFileSize = 30 * 1024 * 1024
        if (!maximumWidth) maximumWidth = 1920
        if (!maximumHeight) maximumHeight = 1280
        if (!standardThumbnailHeight) standardThumbnailHeight = 90
        if (!uploadDirectory) uploadDirectory = "images/${contest}"
    }

}
