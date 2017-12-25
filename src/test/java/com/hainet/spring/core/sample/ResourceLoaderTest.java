package com.hainet.spring.core.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceLoaderTest {

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * {@link Resource#getFile}はリソースがファイルシステム上にあることを期待している。
     * そのためクラスパスからの相対パスで指定すると、IDE上ではアクセスに成功するがJarにするとアクセスに失敗する。
     * 実際{@link ClassPathResource}には{@link Resource#getFile}メソッドが実装されておらず、
     * 代わりに{@link Resource#getInputStream()}を利用する。
     *
     * @throws IOException
     */
    @Test
    public void classPathResourceTest() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + "resource-loader/class-path-resource");
        assertThat(resource, is(instanceOf(ClassPathResource.class)));
        assertThat(
                FileCopyUtils.copyToString(new InputStreamReader(resource.getInputStream())),
                is("class-path-resource\n")
        );
    }

    @Test
    public void classPathContextResourceTest() throws IOException {
        Resource nothing = resourceLoader.getResource("resource-loader/class-path-context-resource");
        assertThat(nothing.getClass().getSimpleName(), is("ClassPathContextResource"));
        assertThat(
                FileCopyUtils.copyToString(new InputStreamReader(nothing.getInputStream())),
                is("class-path-context-resource\n")
        );

        Resource leadingSlash = resourceLoader.getResource("/" + "resource-loader/class-path-context-resource");
        assertThat(leadingSlash.getClass().getSimpleName(), is("ClassPathContextResource"));
        assertThat(
                FileCopyUtils.copyToString(new InputStreamReader(leadingSlash.getInputStream())),
                is("class-path-context-resource\n")
        );
    }

    @Test
    public void urlResourceTest() throws IOException {
        Resource resource = resourceLoader.getResource("https://www.google.com");
        assertThat(resource, is(instanceOf(UrlResource.class)));
        assertThat(
                FileCopyUtils.copyToString(new InputStreamReader(resource.getInputStream())),
                is(containsString("google"))
        );
    }
}
