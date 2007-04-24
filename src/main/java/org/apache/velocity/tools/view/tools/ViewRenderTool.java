package org.apache.velocity.tools.view.tools;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.generic.RenderTool;
import org.apache.velocity.tools.view.ViewContext;

/**
 * This tool expose methods to evaluate the given
 * strings as VTL (Velocity Template Language)
 * and automatically using the current context.
 * <br />
 * <pre>
 * Example of eval():
 *      Input
 *      -----
 *      #set( $list = [1,2,3] )
 *      #set( $object = '$list' )
 *      #set( $method = 'size()' )
 *      $render.eval("${object}.$method")
 *
 *      Output
 *      ------
 *      3
 *
 * Example of recurse():
 *      Input
 *      -----
 *      #macro( say_hi )hello world!#end
 *      #set( $foo = '#say_hi()' )
 *      #set( $bar = '$foo' )
 *      $render.recurse('$bar')
 *
 *      Output
 *      ------
 *      hello world!
 *
 *
 * Toolbox configuration:
 * &lt;tool&gt;
 *   &lt;key&gt;render&lt;/key&gt;
 *   &lt;scope&gt;request&lt;/scope&gt;
 *   &lt;class&gt;org.apache.velocity.tools.view.tools.ViewRenderTool&lt;/class&gt;
 *   &lt;parameter name="parse.depth" value="10"/&gt;
 * &lt;/tool&gt;
 * </pre>
 *
 * <p>Ok, so these examples are really lame.  But, it seems like
 * someone out there is always asking how to do stuff like this
 * and we always tell them to write a tool.  Now we can just tell
 * them to use this tool.</p>
 *
 * <p>This tool is NOT meant to be used in either application or
 * session scopes of a servlet environment.</p>
 *
 * @author Nathan Bubna
 * @version $Revision$ $Date$
 */
public class ViewRenderTool extends RenderTool
{
    private Context context;

    /**
     * Constructs a new instance
     */
    public ViewRenderTool()
    {}


    /**
     * Initializes this instance.
     *
     * @param obj the current Context
     */
    public void init(Object obj)
    {
        context = (Context)obj;

        // if ViewContext, try to retrieve a VelocityEngine for use
        if (obj instanceof ViewContext)
        {
            setVelocityEngine(((ViewContext)obj).getVelocityEngine());
        }
    }

    /**
     * <p>Evaluates a String containing VTL using the current context,
     * and returns the result as a String.  If this fails, then
     * <code>null</code> will be returned.  This evaluation is not
     * recursive.</p>
     *
     * @param vtl the code to be evaluated
     * @return the evaluated code as a String
     */
    public String eval(String vtl) throws Exception
    {
        return eval(context, vtl);
    }


    /**
     * <p>Recursively evaluates a String containing VTL using the
     * current context, and returns the result as a String. It
     * will continue to re-evaluate the output of the last
     * evaluation until an evaluation returns the same code
     * that was fed into it.</p>
     *
     * @param vtl the code to be evaluated
     * @return the evaluated code as a String
     */
    public String recurse(String vtl) throws Exception
    {
        return recurse(context, vtl);
    }


}
