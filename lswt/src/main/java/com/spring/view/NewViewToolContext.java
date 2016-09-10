/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.spring.view;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.context.InternalEventContext;
import org.apache.velocity.tools.view.ViewToolContext;

/**
 * 
 * @author lisong
 * @version $Id: NewViewToolContext.java, v 0.1 2016年9月10日 下午5:35:53 lisong Exp $
 */
public class NewViewToolContext extends ViewToolContext implements InternalEventContext {

    /**
     *  EventCartridge we are to carry.  Set by application
     */
    private EventCartridge eventCartridge = null;

    /**
     * @param velocity
     * @param request
     * @param response
     * @param application
     */
    public NewViewToolContext(VelocityEngine velocity, HttpServletRequest request,
                              HttpServletResponse response, ServletContext application) {
        super(velocity, request, response, application);
    }

    /** 
     * @see org.apache.velocity.context.InternalEventContext#attachEventCartridge(org.apache.velocity.app.event.EventCartridge)
     */
    @Override
    public EventCartridge attachEventCartridge(EventCartridge ec) {
        EventCartridge temp = eventCartridge;
        eventCartridge = ec;
        return temp;
    }

    /** 
     * @see org.apache.velocity.context.InternalEventContext#getEventCartridge()
     */
    @Override
    public EventCartridge getEventCartridge() {
        return eventCartridge;
    }

}
