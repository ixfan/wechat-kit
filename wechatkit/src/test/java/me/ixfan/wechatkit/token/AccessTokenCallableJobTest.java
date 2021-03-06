/*
 * MIT License
 *
 * Copyright (c) 2016 Warren Fan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.ixfan.wechatkit.token;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.fail;

/**
 * Created by xfan on 16/5/15.
 */
public class AccessTokenCallableJobTest {

    @Ignore("APPSECRET 不能公开, 在 Travis CI 中 build 时忽略此测试用例.")
    @Test
    public void successfullyRetrievedAccessToken() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<AccessToken> task = new ObtainAccessTokenCallableJob();
        Future<AccessToken> future = executor.submit(task);
        try {
            AccessToken accessToken = future.get();
            executor.shutdown();
            Assert.assertNotNull(accessToken);
            Assert.assertNotNull(accessToken.getAccessToken());
            Assert.assertNotNull(accessToken.getExpiresIn());
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("Task has been interrupted!");
        } catch (ExecutionException e) {
            e.printStackTrace();
            fail("Exception should not occurred!");
        }
    }
}
