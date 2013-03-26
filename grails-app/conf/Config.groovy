/*
 * ImageGallery
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

grails.project.groupId = 'eu.artofcoding.imagegallery'

grails.mime.file.extensions = true
grails.mime.use.accept.header = false
grails.mime.types = [
        html: [
                'text/html',
                'application/xhtml+xml'
        ],
        xml: [
                'text/xml',
                'application/xml'
        ],
        text: 'text/plain',
        js: 'text/javascript',
        rss: 'application/rss+xml',
        atom: 'application/atom+xml',
        css: 'text/css',
        csv: 'text/csv',
        all: '*/*',
        json: [
                'text/json',
                'application/json'
        ],
        form: 'application/x-www-form-urlencoded',
        multipartForm: 'multipart/form-data'
]

grails.resources.adhoc.patterns = [
        '/images/*',
        '/css/*',
]

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"

grails.views.gsp.sitemesh.preprocess = true
grails.views.javascript.library = "jquery"
grails.scaffolding.templates.domainSuffix = 'Instance'
grails.json.legacy.builder = false
grails.enable.native2ascii = true
grails.spring.bean.packages = []
grails.web.disable.multipart = false
grails.exceptionresolver.params.exclude = ['password']
grails.gorm.failOnError = true
grails.hibernate.cache.queries = true
environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        grails.serverURL = "http://localhost/"
        grails.dbconsole.enabled = true
        //grails.dbconsole.urlRoot = '/admin/dbconsole'
    }
}
log4j = {
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}
    /*
    trace 'grails.app.controllers.eu.artofcoding.imagegallery'
    */
    error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
            'org.codehaus.groovy.grails.web.pages', //  GSP
            'org.codehaus.groovy.grails.web.sitemesh', //  layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping', // URL mapping
            'org.codehaus.groovy.grails.commons', // core / classloading
            'org.codehaus.groovy.grails.plugins', // plugins
            'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
}
