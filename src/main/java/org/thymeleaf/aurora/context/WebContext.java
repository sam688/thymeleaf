/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.aurora.context;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 3.0.0 (replaces interface with the same name existing since 1.0)
 *
 */
public final class WebContext extends AbstractContext implements IWebContext {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ServletContext servletContext;


    public WebContext(final HttpServletRequest request, final HttpServletResponse response,
                      final ServletContext servletContext) {
        super();
        this.request = request;
        this.response = response;
        this.servletContext = servletContext;
    }

    public WebContext(final HttpServletRequest request, final HttpServletResponse response,
                      final ServletContext servletContext, final Locale locale) {
        super(locale);
        this.request = request;
        this.response = response;
        this.servletContext = servletContext;
    }

    public WebContext(final HttpServletRequest request, final HttpServletResponse response,
                      final ServletContext servletContext, final Locale locale, final Map<String, Object> variables) {
        super(locale, variables);
        this.request = request;
        this.response = response;
        this.servletContext = servletContext;
    }


    public HttpServletRequest getRequest() {
        return this.request;
    }

    public HttpSession getSession() {
        return this.request.getSession(false);
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }
}
