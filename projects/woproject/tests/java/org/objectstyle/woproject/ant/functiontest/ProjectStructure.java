/* ====================================================================
 *
 * The ObjectStyle Group Software License, Version 1.0
 *
 * Copyright (c) 2002 The ObjectStyle Group
 * and individual authors of the software.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        ObjectStyle Group (http://objectstyle.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "ObjectStyle Group" and "Cayenne"
 *    must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact andrus@objectstyle.org.
 *
 * 5. Products derived from this software may not be called "ObjectStyle"
 *    nor may "ObjectStyle" appear in their names without prior written
 *    permission of the ObjectStyle Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE OBJECTSTYLE GROUP OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the ObjectStyle Group.  For more
 * information on the ObjectStyle Group, please see
 * <http://objectstyle.org/>.
 *
 */

package org.objectstyle.woproject.ant.functiontest;


/**
 * Java bean that keeps information about WebObjects
 * project structure.
 *
 * @author Andrei Adamchik
 */
public abstract class ProjectStructure {
    protected String name;
    protected String[] jars;
    protected String[] wocomps;
    protected String[] wsResources;

    public ProjectStructure(String name) {
        this.name = name;
    }

    /**
     * Subclasses must implement that to return either framework
     * or application directory name relative to tests distribution
     * directory.
     */
    public abstract String getDirectoryPath();

    public abstract String getRelativeResourcesPath();

    public abstract String getRelativeWSResourcesPath();

    public abstract String getRelativeInfoPath();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasWebServerResources() {
        return wsResources != null && wsResources.length > 0;
    }

    public boolean hasJava() {
        return jars != null && jars.length > 0;
    }

    public boolean hasWos() {
        return wocomps != null && wocomps.length > 0;
    }

    public String[] getJars() {
        return jars;
    }

    public void setJars(String[] jars) {
        this.jars = jars;
    }
    
    public void addToJars(String jar) {
    	this.jars = addToArray(jars, jar);
    }

    public String[] getWocomps() {
        return wocomps;
    }

    public void setWocomps(String[] wocomps) {
        this.wocomps = wocomps;
    }
    
    public void addToWocomps(String wocomp) {
    	this.wocomps = addToArray(wocomps, wocomp);
    }

    public String[] getWsResources() {
        return wsResources;
    }

    public void setWsResources(String[] wsres) {
        this.wsResources = wsres;
    }
    
    public void addToWsResources(String wsResource) {
    	this.wsResources = addToArray(wsResources, wsResource);
    }

    /** Grows String array by one element, adds the element at the end. */
    public static String[] addToArray(String[] array, String element) {
    	if(array == null || array.length == 0) {
    		return new String[] {element};
    	}
    	
    	String[] grown = new String[array.length + 1];
    	System.arraycopy(array, 0, grown, 0, array.length);
    	grown[array.length] = element;
    	return grown;
    }
}