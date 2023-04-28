package edu.umd.enpm614.assignment2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //for FrontendGWT
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.FrontendGWT.*(..))")
    public Object logExecutionTimeFrontGWT(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for FrontendHTML
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.FrontendHTML.*(..))")
    public Object logExecutionTimeFrontHTML(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for MiddlewareJBoss
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.MiddlewareJBoss.*(..))")
    public Object logExecutionTimeMiddleJBoss(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for MiddlewareTomcat
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.MiddlewareTomcat.*(..))")
    public Object logExecutionTimeMiddleTomcat(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for PersistenceMySQL
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.PersistenceMySQL.*(..))")
    public Object logExecutionTimePersistenceMySQL(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for PersistenceOracle
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.PersistenceOracle.*(..))")
    public Object logExecutionTimePersistenceOracle(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for AuthenticationSSL
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.AuthenticationSSL.*(..))")
    public Object logExecutionTimeAuthenticationSSL(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for AuthenticationTSL
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.AuthenticationTSL.*(..))")
    public Object logExecutionTimeAuthenticationTSL(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for FileSystemNFS
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.FileSystemNFS.*(..))")
    public Object logExecutionTimeFileSystemNFS(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for FileSystemNTFS
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.FileSystemNTFS.*(..))")
    public Object logExecutionTimeFileSystemNTFS(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for ConnectionJDBC
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.ConnectionJDBC.*(..))")
    public Object logExecutionTimeConnectionJDBC(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }

    //for ConnectionPooled
    @Around("within(edu.umd.enpm614.assignment2.services.*) && execution(public * *edu.umd.enpm614.assignment2.services.ConnectionPooled.*(..))")
    public Object logExecutionTimeConnectionPooled(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append("QualifiedClassName " + joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append("methodName "+ joinPoint.getSignature().getName())
                .append(" is ").append((System.nanoTime()- startTime)/1000000)
                .append("ms");
        System.out.println(sb.toString());
        return value;
    }
}
