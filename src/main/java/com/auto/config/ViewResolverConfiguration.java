package com.auto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 主要配置多视图实现的视图解析器相关bean实例
 * 
 * @author song
 */
@Configuration
public class ViewResolverConfiguration {

	@Bean
	public InternalResourceViewResolver getJspViewResolver() {
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
		jspViewResolver.setPrefix("/WEB-INF/");
		jspViewResolver.setSuffix(".jsp");
		jspViewResolver.setViewClass(JstlView.class);
		// 通过ViewNames属性来实现，通过请求中返回的视图名称匹配其采用哪个对应的视图解析器处理，从而找到对应prefix下的页面
		jspViewResolver.setViewNames("jsp/*");
		jspViewResolver.setOrder(10);
		// 开发时不启用缓存，改动即可生效
		jspViewResolver.setCache(false);
		return jspViewResolver;
	}
}
