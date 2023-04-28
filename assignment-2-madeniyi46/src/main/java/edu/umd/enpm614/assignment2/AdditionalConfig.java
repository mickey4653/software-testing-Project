package edu.umd.enpm614.assignment2;

import edu.umd.enpm614.assignment2.application.WebApplication;
import edu.umd.enpm614.assignment2.interfaces.*;
import edu.umd.enpm614.assignment2.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_2_ENV;

@Profile(TASK_2_ENV)
@Configuration
public class AdditionalConfig {
    public static final String INJECT_AUTHENTICATION_TSL = "edu.umd.enpm614.assignment2.services.AuthenticationTSL";
    public static final String INJECT_FRONTEND_GWT= "edu.umd.enpm614.assignment2.services.FrontendGWT";
    public static final String INJECT_MIDDLEWARE_JBOSS = "edu.umd.enpm614.assignment2.services.MiddlewareJBoss";
    public static final String INJECT_PERSISTENCE_ORACLE = "edu.umd.enpm614.assignment2.services.PersistenceOracle";
    public static final String INJECT_FILESYSTEM_NFS = "edu.umd.enpm614.assignment2.services.FileSystemNFS";
    public static final String INJECT_CONNECTION_JDBC = "edu.umd.enpm614.assignment2.services.ConnectionJDBC";
    @Primary
    @Bean(name = INJECT_AUTHENTICATION_TSL)
    public Authentication getAuthenticationTSL(){
        return new AuthenticationTSL();
    }

    @Primary
    @Bean(name = INJECT_FRONTEND_GWT)
    public Frontend getFrontendGWT(){
        return new FrontendGWT(getAuthenticationTSL());
    }


    @Primary
    @Bean(name = INJECT_MIDDLEWARE_JBOSS)
    public Middleware getMiddlewareJBoss(){
        return new MiddlewareJBoss();
    }

    @Primary
    @Bean(name = INJECT_PERSISTENCE_ORACLE)
    public Persistence getPersistence(){
        return new PersistenceOracle(getFileSystemNFS(),getConnectionJDBC());
    }

    @Primary
    @Bean(name = INJECT_FILESYSTEM_NFS)
    public FileSystem getFileSystemNFS(){
        return new FileSystemNFS();
    }

    @Primary
    @Bean(name = INJECT_CONNECTION_JDBC)
    public Connection getConnectionJDBC(){
        return new ConnectionJDBC();
    }



}
