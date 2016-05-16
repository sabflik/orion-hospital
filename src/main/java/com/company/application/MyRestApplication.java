package com.company.application;

import com.company.services.HelloResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Entry point into REST service for Application</p>
 * @author Chang Kon Han
 * @author John Law
 * @author Wesley Yep
 * @since 23 Feb 2016
 */
@ApplicationPath("/services")
public class MyRestApplication extends Application {

    private Set<Class<?>> components = new HashSet<Class<?>>();

    public MyRestApplication() {
        components.add(HelloResource.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return components;
    }
}
