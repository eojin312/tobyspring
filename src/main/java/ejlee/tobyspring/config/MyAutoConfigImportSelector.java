package ejlee.tobyspring.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
            "ejlee.tobyspring.config.autoConfig.DispatcherServletConfig",
            "ejlee.tobyspring.config.autoConfig.TomcatWebServerConfig"
        };
    }
}
