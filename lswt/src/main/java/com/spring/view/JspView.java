/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.spring.view;

import java.io.File;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lisong
 * @version $Id: JspView.java, v 0.1 2016年9月9日 下午10:01:14 lisong Exp $
 */
public class JspView extends org.springframework.web.servlet.view.JstlView {
    /**
    * Logger for this class
    */
    private static final Logger LOGGER = LoggerFactory.getLogger("ls.demon.VelocityToolbox20View");

    /** 
     * @see org.springframework.web.servlet.view.AbstractUrlBasedView#checkResource(java.util.Locale)
     */
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        LOGGER.debug("{}, {}, {}", locale, this.getServletContext().getRealPath("/"), getUrl());
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        LOGGER.debug("{}", file);
        //判断该jsp页面是否存在  
        return file.exists();
    }

}
