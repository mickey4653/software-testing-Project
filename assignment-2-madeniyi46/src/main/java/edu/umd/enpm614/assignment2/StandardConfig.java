package edu.umd.enpm614.assignment2;

import edu.umd.enpm614.assignment2.application.WebApplication;
import edu.umd.enpm614.assignment2.interfaces.*;
import edu.umd.enpm614.assignment2.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_1_ENV;

@Profile(TASK_1_ENV)
@Configuration
public class StandardConfig {

    public static final String INJECT_AUTHENTICATION_SSL = "edu.umd.enpm614.assignment2.services.AuthenticationSSL";
    public static final String INJECT_FRONTEND_HTML = "edu.umd.enpm614.assignment2.services.FrontendHTML";
    public static final String INJECT_MIDDLEWARE_TOMCAT = "edu.umd.enpm614.assignment2.services.MiddlewareTomcat";
    public static final String INJECT_PERSISTENCE_MySQL = "edu.umd.enpm614.assignment2.services.PersistenceMySQL";
    public static final String INJECT_FILESYSTEM_NTFS = "edu.umd.enpm614.assignment2.services.FileSystemNTFS";
    public static final String INJECT_CONNECTION_POOLED = "edu.umd.enpm614.assignment2.services.ConnectionPooled";

//    public static final String INJECT_WEBSERVER = "edu.umd.enpm614.assignment2.application.WebServer";
//    public static final String INJECT_WEB_APPLICATION = "edu.umd.enpm614.assignment2.application.WebApplication";


    @Primary
    @Bean(name = INJECT_AUTHENTICATION_SSL)
    public Authentication getAuthenticationSSL(){
        return new AuthenticationSSL();
    }
    @Primary
    @Bean(name = INJECT_FRONTEND_HTML)
    public Frontend getFrontendHTML(){
        return new FrontendHTML(getAuthenticationSSL());
    }
    @Primary
    @Bean(name = INJECT_MIDDLEWARE_TOMCAT)
    public Middleware getMiddlewareTomcat(){
        return new MiddlewareTomcat();
    }
    @Primary
    @Bean(name = INJECT_FILESYSTEM_NTFS)
    public FileSystem getFileSystemNTFS(){
        return new FileSystemNTFS();
    }

    @Primary
    @Bean(name = INJECT_CONNECTION_POOLED)
    public Connection getConnectionPooled(){
        return new ConnectionPooled();
    }
    @Primary
    @Bean(name=INJECT_PERSISTENCE_MySQL)
    public Persistence getPersistenceMySQL(){
        return new PersistenceMySQL(getFileSystemNTFS(), getConnectionPooled());
    }
}
