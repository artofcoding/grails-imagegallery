/*
 * ImageGallery
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

package eu.artofcoding.imagegallery

class ImageGalleryTagLib {

    /**
     * Our namespace.
     */
    static namespace = "ig"

    def gallery = { attr, body ->
        def d = [2010, 2011, 2012]
        out << "<div id=\"menu\">"
        d.each {
            out << "<li><a href=\"${it}\">${it}</a></li>"
        }
        out << "</div>"
    }

}
