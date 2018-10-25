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