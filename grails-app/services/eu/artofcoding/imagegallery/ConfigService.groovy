/*
 * ImageGallery
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

package eu.artofcoding.imagegallery

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.hibernate.FetchMode
import org.springframework.beans.factory.InitializingBean

/**
 * This service provides access to our configuration.
 * @author rbe
 */
class ConfigService implements InitializingBean {

    GrailsApplication grailsApplication

    ImageGalleryConfig imageGalleryConfig

    List<ContestConfig> contestConfigs

    /**
     * @see InitializingBean#afterPropertiesSet
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        /*
         // Load Groovy configuration file
         imageGalleryConfig = grailsApplication.config.imagegallery
         */
        // ImageGalleryConfig
        imageGalleryConfig = ImageGalleryConfig.withCriteria(uniqueResult: true) {
            eq('id', 1L)
            fetchMode('fileTypes', FetchMode.EAGER)
        }
        // Load configuration for contests from database
        contestConfigs = ContestConfig.list()
    }

    /**
     *
     * @param what
     * @return
     */
    public Object get(String what) {
        switch (what) {
            case 'imageGalleryConfig':
                imageGalleryConfig
                break
            default:
                for (cc in contestConfigs) {
                    def found = cc.contest.find { it == what }
                    if (found) {
                        return cc
                    }
                }

        }
    }

}
