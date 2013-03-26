/*
 * Flux
 * Copyright (C) 2009-2010 Informationsysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 */

package eu.artofcoding.flux.http

import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.support.WebApplicationContextUtils

import javax.servlet.http.HttpSessionEvent
import javax.servlet.http.HttpSessionListener

/**
 * Delegate HTTP session events to a Grails service.
 * @author rbe
 */
class FluxSessionListener implements HttpSessionListener {

    private HttpSessionService httpSessionService

    private synchronized HttpSessionService getHttpSessionService(servletContext) {
        WebApplicationContext x = WebApplicationContextUtils.getWebApplicationContext(servletContext)
        if (null == httpSessionService) {
            httpSessionService = (HttpSessionService) x.getBean('httpSessionService')
        }
        return httpSessionService
    }

    /**
     * Called by servlet container upon session creation.
     * @param event
     */
    void sessionCreated(HttpSessionEvent event) {
        getHttpSessionService(event.session.servletContext).sessionCreated(event)
    }

    /**
     * Called by servlet container upon session destruction.
     * @param event
     */
    void sessionDestroyed(HttpSessionEvent event) {
        getHttpSessionService(event.session.servletContext).sessionDestroyed(event)
    }

}
