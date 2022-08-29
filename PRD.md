用户登录模块
1- /user/login.do
| request 
username,password
| response
fail
success

2- /user/register.do
| request 
username,password,email,phone,question,answer
| response
fail
success

3- /user/check_valid.do
| request 
str.type
username/email
| response
fail
success

4- /user/get_user_info.do
| request 
无
| response
fail
success

5- /user/forget_get_question.do
| request 
username
| response
fail
success

6- /user/forget_check_answer.do
| request 
username,question,answer
| response
fail
success

7- /user/forget_reset_password.do
| request 
username,passwordNew,forgetToken
| response
fail
success

8- /user/reset_password.do
| request 
passwordOld,passwordNew
| response
fail
success

9- /user/update_information.do
| request 
email,phone,question,answer
| response
fail
success

10- /user/get_information.do
| request 
无
| response
fail
success

11- /user/logout.do
| request 
无
| response
fail
success

01- /manage/user/login.do
| request 
username,password
| response
fail
success

分类管理模块接口
01- /manage/category/get_category.do
| request 
categoryId
| response
fail
success

02- /manage/category/add_category.do
| request 
parentId,categoryName
| response
fail
success

03- /manage/category/set_category_name.do
| request 
categoryId,categoryName
| response
fail
success

04- /manage/category/get_deep_category.do
| request 
categoryId
| response
fail
success

商品管理模块
前台
01- /product/list.do
| request 
categoryId
keyword
pageNum(default=1)
pageSize(default=10)
orderBy(default=""")
| response
fail
success

02- product/detail.do
| request 
productId
| response
fail
success

后台
01- /manage/product/list.do
| request 
pageNum(default=1)
pageSize(default=10)
| response
fail
success

02- /manage/product/search.do
| request 
productId
productName
pageNum(default=1)
pageSize(default=10)
| response
fail
success

03- /manage/product/upload.do
| request 
<form enctype="multipart/form-data">
</form>
| response
fail
success

04- /manage/product/detail.do
| request 
productId
| response
fail
success

05- /manage/product/set_sale_status.do
| request 
productId
status
| response
fail
success

06- /manage/product/upsertProduct.do
| request 
productId
status
| response
fail
success

07- /manage/product/richText_img_upload.do
| request 
<form enctype="multipart/form-data">
</form>
| response
fail
success

