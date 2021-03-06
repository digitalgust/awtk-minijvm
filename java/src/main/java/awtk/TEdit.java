package awtk;


/**
 * 单行编辑器控件。
 *
 *在基于SDL的平台，单行编辑器控件使用平台原生的输入法，对于嵌入式平台使用内置的输入法。
 *
 *在使用内置的输入法时，软键盘由输入类型决定，开发者可以自定义软键盘的界面。
 *
 *edit\_t是[widget\_t](widget_t.md)的子类控件，widget\_t的函数均适用于edit\_t控件。
 *
 *edit\_t本身可以做为容器，放入按钮等控件。有几个特殊的子控件：
 *
 ** 名为"clear"的按钮。点击时清除编辑器中的内容。
 ** 名为"inc"的按钮。点击时增加编辑器的值，用于实现类似于spinbox的功能。
 ** 名为"dec"的按钮。点击时减少编辑器的值，用于实现类似于spinbox的功能。
 ** 名为"visible"的复选框。勾选时显示密码，反之不显示密码。
 *
 *在xml中使用"edit"标签创建编辑器控件。如：
 *
 *```xml
 *<edit x="c" y="m" w="80" h="30"
 *tips="age" input_type="uint" min="0" max="150" step="1" auto_fix="true" style="number" />
 *```
 *
 *> XXX：需要在min/max/step之前设置input\_type。
 *
 *>更多用法请参考：
 *[edit.xml](https://github.com/zlgopen/awtk/blob/master/demos/assets/default/raw/ui/edit.xml)
 *
 *在c代码中使用函数edit\_create创建编辑器控件。如：
 *
 *
 *> 创建之后，可以用widget\_set\_text或widget\_set\_text\_utf8设置文本内容。
 *
 *> 完整示例请参考：
 *[edit demo](https://github.com/zlgopen/awtk-c-demos/blob/master/demos/edit.c)
 *
 *可用通过style来设置控件的显示风格，如字体的大小和颜色等等。如：
 *
 *```xml
 *<style name="default" border_color="#a0a0a0"  text_color="black" text_align_h="left">
 *<normal     bg_color="#f0f0f0" />
 *<focused    bg_color="#f0f0f0" border_color="black"/>
 *<disable    bg_color="gray" text_color="#d0d0d0" />
 *<error      bg_color="#f0f0f0" text_color="red" />
 *<empty      bg_color="#f0f0f0" text_color="#a0a0a0" />
 *</style>
 *```
 *
 *> 更多用法请参考：
 *[theme
 *default](https://github.com/zlgopen/awtk/blob/master/demos/assets/default/raw/styles/default.xml#L104)
 *
 */
public class TEdit extends TWidget { 

/**
 * 通过nativeObj构造Java对象。
 *
 * @param nativeObj 原生对象。

 * @return 对应的Java对象。
 */
 public TEdit(long nativeObj) {
   super(nativeObj);
 }


/**
 * 把nativeObj转换层Java对象。
 *
 * @param nativeObj 原生对象。

 * @return 对应的Java对象。
 */
 static public TEdit cast(long nativeObj) {
   return new TEdit(nativeObj);
 }


/**
 * 创建edit对象
 * 
 * @param parent 父控件
 * @param x x坐标
 * @param y y坐标
 * @param w 宽度
 * @param h 高度
 
 * @return 对象。
 */
 public  static TWidget create(TWidget parent, int x, int y, int w, int h)  {
    return new TEdit(edit_create(parent != null ? (parent.nativeObj) : 0, x, y, w, h));
 }


/**
 * 转换为edit对象(供脚本语言使用)。
 * 
 * @param widget edit对象。
 
 * @return edit对象。
 */
 public  static TEdit cast(TWidget widget)  {
    return new TEdit(edit_cast(widget != null ? (widget.nativeObj) : 0));
 }


/**
 * 获取int类型的值。
 * 
 
 * @return 返回int的值。
 */
 public  int getInt()  {
    return edit_get_int(this != null ? (this.nativeObj) : 0);
 }


/**
 * 获取double类型的值。
 * 
 
 * @return 返回double的值。
 */
 public  double getDouble()  {
    return edit_get_double(this != null ? (this.nativeObj) : 0);
 }


/**
 * 设置int类型的值。
 * 
 * @param value 值。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setInt(int value)  {
   return TRet.from(edit_set_int(this != null ? (this.nativeObj) : 0, value));
 }


/**
 * 设置double类型的值。
 * 
 * @param value 值。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setDouble(double value)  {
   return TRet.from(edit_set_double(this != null ? (this.nativeObj) : 0, value));
 }


/**
 * 设置为文本输入及其长度限制，不允许输入超过max个字符，少于min个字符时进入error状态。
 * 
 * @param min 最小长度。
 * @param max 最大长度。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setTextLimit(int min, int max)  {
   return TRet.from(edit_set_text_limit(this != null ? (this.nativeObj) : 0, min, max));
 }


/**
 * 设置为整数输入及取值范围。
 * 
 * @param min 最小值。
 * @param max 最大值。
 * @param step 步长。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setIntLimit(int min, int max, int step)  {
   return TRet.from(edit_set_int_limit(this != null ? (this.nativeObj) : 0, min, max, step));
 }


/**
 * 设置为浮点数输入及取值范围。
 * 
 * @param min 最小值。
 * @param max 最大值。
 * @param step 步长。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setFloatLimit(double min, double max, double step)  {
   return TRet.from(edit_set_float_limit(this != null ? (this.nativeObj) : 0, min, max, step));
 }


/**
 * 设置编辑器是否为只读。
 * 
 * @param readonly 只读。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setReadonly(boolean readonly)  {
   return TRet.from(edit_set_readonly(this != null ? (this.nativeObj) : 0, readonly));
 }


/**
 * 设置编辑器是否为自动改正。
 * 
 * @param auto_fix 自动改正。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setAutoFix(boolean auto_fix)  {
   return TRet.from(edit_set_auto_fix(this != null ? (this.nativeObj) : 0, auto_fix));
 }


/**
 * 设置编辑器是否在获得焦点时不选中文本。
 * 
 * @param select_none_when_focused 是否在获得焦点时不选中文本。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setSelectNoneWhenFocused(boolean select_none_when_focused)  {
   return TRet.from(edit_set_select_none_when_focused(this != null ? (this.nativeObj) : 0, select_none_when_focused));
 }


/**
 * 设置编辑器是否在获得焦点时打开输入法。
 * 
 * @param open_im_when_focused 是否在获得焦点时打开输入法。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setOpenImWhenFocused(boolean open_im_when_focused)  {
   return TRet.from(edit_set_open_im_when_focused(this != null ? (this.nativeObj) : 0, open_im_when_focused));
 }


/**
 * 设置编辑器的输入类型。
 * 
 * @param type 输入类型。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setInputType(TInputType type)  {
   return TRet.from(edit_set_input_type(this != null ? (this.nativeObj) : 0, type.value()));
 }


/**
 * 设置编辑器的输入提示。
 * 
 * @param tips 输入提示。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setInputTips(String tips)  {
   return TRet.from(edit_set_input_tips(this != null ? (this.nativeObj) : 0, tips));
 }


/**
 * 当编辑器输入类型为密码时，设置密码是否可见。
 * 
 * @param password_visible 密码是否可见。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setPasswordVisible(boolean password_visible)  {
   return TRet.from(edit_set_password_visible(this != null ? (this.nativeObj) : 0, password_visible));
 }


/**
 * 设置为焦点。
 * 
 * @param focus 是否为焦点。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setFocus(boolean focus)  {
   return TRet.from(edit_set_focus(this != null ? (this.nativeObj) : 0, focus));
 }


/**
 * 设置输入框的光标坐标。
 * 
 * @param cursor 是否为焦点。
 
 * @return 返回RET_OK表示成功，否则表示失败。
 */
 public  TRet setCursor(int cursor)  {
   return TRet.from(edit_set_cursor(this != null ? (this.nativeObj) : 0, cursor));
 }


/**
 * 编辑器是否为只读。
 *
 */
 public boolean getReadonly() {
   return edit_t_get_prop_readonly(this.nativeObj);
 }


/**
 * 密码是否可见。
 *
 */
 public boolean getPasswordVisible() {
   return edit_t_get_prop_password_visible(this.nativeObj);
 }


/**
 * 输入无效时，是否自动改正。
 *
 */
 public boolean getAutoFix() {
   return edit_t_get_prop_auto_fix(this.nativeObj);
 }


/**
 * 获得焦点时不选中文本。
 *
 *> 主要用于没有指针设备的情况，否则软键盘无法取消选中文本。
 *
 */
 public boolean getSelectNoneWhenFocused() {
   return edit_t_get_prop_select_none_when_focused(this.nativeObj);
 }


/**
 * 获得焦点时打开输入法。
 *
 *> 主要用于没有指针设备的情况，否则每次切换焦点时都打开输入法。
 *
 */
 public boolean getOpenImWhenFocused() {
   return edit_t_get_prop_open_im_when_focused(this.nativeObj);
 }


/**
 * 输入提示。
 *
 */
 public String getTips() {
   return edit_t_get_prop_tips(this.nativeObj);
 }


/**
 * 输入类型。
 *
 */
 public TInputType getInputType() {
   return TInputType.from(edit_t_get_prop_input_type(this.nativeObj));

 }


/**
 * 最小值或最小长度。
 *
 */
 public double getMin() {
   return edit_t_get_prop_min(this.nativeObj);
 }


/**
 * 最大值或最大长度。
 *
 */
 public double getMax() {
   return edit_t_get_prop_max(this.nativeObj);
 }


/**
 * 步长。
 *作为数值型编辑器时，一次增加和减少时的数值。
 *
 */
 public double getStep() {
   return edit_t_get_prop_step(this.nativeObj);
 }

static private native long edit_create(long parent, int x, int y, int w, int h);
static private native long edit_cast(long widget);
static private native int edit_get_int(long widget);
static private native double edit_get_double(long widget);
static private native int edit_set_int(long widget, int value);
static private native int edit_set_double(long widget, double value);
static private native int edit_set_text_limit(long widget, int min, int max);
static private native int edit_set_int_limit(long widget, int min, int max, int step);
static private native int edit_set_float_limit(long widget, double min, double max, double step);
static private native int edit_set_readonly(long widget, boolean readonly);
static private native int edit_set_auto_fix(long widget, boolean auto_fix);
static private native int edit_set_select_none_when_focused(long widget, boolean select_none_when_focused);
static private native int edit_set_open_im_when_focused(long widget, boolean open_im_when_focused);
static private native int edit_set_input_type(long widget, int type);
static private native int edit_set_input_tips(long widget, String tips);
static private native int edit_set_password_visible(long widget, boolean password_visible);
static private native int edit_set_focus(long widget, boolean focus);
static private native int edit_set_cursor(long widget, int cursor);
static private native boolean edit_t_get_prop_readonly(long nativeObj);
static private native boolean edit_t_get_prop_password_visible(long nativeObj);
static private native boolean edit_t_get_prop_auto_fix(long nativeObj);
static private native boolean edit_t_get_prop_select_none_when_focused(long nativeObj);
static private native boolean edit_t_get_prop_open_im_when_focused(long nativeObj);
static private native String edit_t_get_prop_tips(long nativeObj);
static private native int edit_t_get_prop_input_type(long nativeObj);
static private native double edit_t_get_prop_min(long nativeObj);
static private native double edit_t_get_prop_max(long nativeObj);
static private native double edit_t_get_prop_step(long nativeObj);
};