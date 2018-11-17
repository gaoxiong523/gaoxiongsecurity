# gaoxiongsecurity
spring security 相关学习
关于aop
可以使用两种方式指定切入位置
```java
 @Around(value = "execution(* com.gaoxiong.webController.UserController.*(..))")
 @Pointcut(value = "execution(* com.gaoxiong.webController.UserController.*(..))")
 详情可以参考springfranmework下的关于aop的文档
```
层级关系
最外层Filter >>原始请求
然后 Interceptor >>请求到哪个方法
然后ControllerAdvice
然后Aspect >> 具体的请求参数都可以获得到
然后是Controller
branch
多线程异步处理,提高rest服务的性能
```java
Callable<T>
DeferredResult<T>
```
需要另外单独配置,线程池,如果不配置的话,默认使用的是spring的默认的SimpleAsyncTaskExecutor

spring security 主要的三个接口
###处理用户信息获取逻辑  UserDetailsService
###处理用户校验逻辑      UserDetails
###处理密码加密解密      PasswordEncoder

自定义登陆页面 http.formLogin().loginPage("/***)
自定义登录成功处理 实现 接口 AuthenticationSuccessHandler
自定义失败处理 AuthenticationFailureHandler
```java
 /**
     * 三种获得当前已登录用户信息的方法
     * @return
     */
    @RequestMapping("/me")
    public Object getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @RequestMapping("/me1")
    public Object getCurrentUser1( Authentication authentication ){
        return authentication;
    }
    @RequestMapping("/me2")
    public Object getCurrentUser2( @AuthenticationPrincipal UserDetails userDetails ){
        return userDetails;
    }
```
