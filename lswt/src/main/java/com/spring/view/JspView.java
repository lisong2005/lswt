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
    private static final Logger logger = LoggerFactory.getLogger(JspView.class);

    /** 
     * @see org.springframework.web.servlet.view.AbstractUrlBasedView#checkResource(java.util.Locale)
     */
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        logger.debug("{}", locale);
        logger.debug("{}", this.getServletContext().getRealPath("/"));
        logger.debug("{}", this.getUrl());
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        logger.debug("{}", file);
        return file.exists();//判断该jsp页面是否存在  
    }

}
