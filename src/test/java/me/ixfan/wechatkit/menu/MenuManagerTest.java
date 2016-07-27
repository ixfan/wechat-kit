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

/**
 * MIT License
 * <p>
 * Copyright (c) 2016 Warren Fan
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package me.ixfan.wechatkit.menu;

import com.google.gson.Gson;
import me.ixfan.wechatkit.menu.model.MenuItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warren Fan
 */
public class MenuManagerTest {

    @Test
    public void correctConvertMenuItemsToJsonString() {
        String expectedMenusInJson = "{\"button\":[{\"name\":\"点我试试\",\"type\":\"click\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"},{\"name\":\"菜单二\",\"sub_button\":[{\"name\":\"点我点我\",\"type\":\"click\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"},{\"name\":\"谷歌搜索\",\"type\":\"view\",\"url\":\"https://www.google.com\"},{\"name\":\"扫码推事件\",\"type\":\"scancode_push\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"},{\"name\":\"扫码带提示\",\"type\":\"scancode_waitmsg\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"}]},{\"name\":\"菜单三\",\"sub_button\":[{\"name\":\"系统拍照发图\",\"type\":\"pic_sysphoto\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"},{\"name\":\"拍照或者相册发图\",\"type\":\"pic_photo_or_album\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"},{\"name\":\"微信相册发图\",\"type\":\"pic_weixin\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"},{\"name\":\"发送位置\",\"type\":\"location_select\",\"key\":\"DEVELOPER_DEFINED_EVENT_KEY\"}]}]}";

        MenuItem levelOneMenu1 = new MenuItem("点我试试", MenuType.CLICK);
        levelOneMenu1.setKey("DEVELOPER_DEFINED_EVENT_KEY");

        MenuItem levelOneMenu2 = new MenuItem("菜单二");
        MenuItem levelOneMenu3 = new MenuItem("菜单三");

        MenuItem menu21 = new MenuItem("点我点我", MenuType.CLICK);
        menu21.setKey("DEVELOPER_DEFINED_EVENT_KEY");
        levelOneMenu2.addSubMenu(menu21);
        MenuItem menu22 = new MenuItem("谷歌搜索", MenuType.VIEW);
        menu22.setUrl("https://www.google.com");
        levelOneMenu2.addSubMenu(menu22);
        MenuItem menu23 = new MenuItem("扫码推事件", MenuType.SCANCODE_PUSH);
        menu23.setKey("DEVELOPER_DEFINED_EVENT_KEY");
        levelOneMenu2.addSubMenu(menu23);
        MenuItem menu24 = new MenuItem("扫码带提示", MenuType.SCANCODE_WAIT_MSG);
        menu24.setKey("DEVELOPER_DEFINED_EVENT_KEY");
        levelOneMenu2.addSubMenu(menu24);

        MenuItem menu31 = new MenuItem("系统拍照发图", MenuType.PIC_SYS_PHOTO);
        menu31.setKey("DEVELOPER_DEFINED_EVENT_KEY");
        levelOneMenu3.addSubMenu(menu31);
        MenuItem menu32 = new MenuItem("拍照或者相册发图", MenuType.PIC_PHOTO_OR_ALBUM);
        menu32.setKey("DEVELOPER_DEFINED_EVENT_KEY");
        levelOneMenu3.addSubMenu(menu32);
        MenuItem menu33 = new MenuItem("微信相册发图", MenuType.PIC_WEIXIN);
        menu33.setKey("DEVELOPER_DEFINED_EVENT_KEY");
        levelOneMenu3.addSubMenu(menu33);
        MenuItem menu34 = new MenuItem("发送位置", MenuType.LOCATION_SELECT);
        menu34.setKey("DEVELOPER_DEFINED_EVENT_KEY");
        levelOneMenu3.addSubMenu(menu34);

        Map<String, Object> menus = new HashMap<>();
        menus.put("button", new MenuItem[] { levelOneMenu1, levelOneMenu2, levelOneMenu3 });

        Gson gson = new Gson();
        String menusInJson = gson.toJson(menus);

        Assert.assertEquals("Compact JSON string should equals!", expectedMenusInJson, menusInJson);
    }
}
