# HotelManage   酒店管理系统
酒店管理系统（Java Web 课程设计）  
This is HotelMangeSystem (Java Practicum)
### 数据库表设计
#### 1. 用户表  存储用户的基本信息，包括用户名、密码、姓名、性别、联系方式等字段

| 字段名  | 用途                  | 字段名           | 类型                   |
|------|---------------------|---------------|----------------------|
| 用户id | 用户的唯一标识符            | user_id       | int 自增 主键            |
| 用户名  | 用户的登录名              | user_name     | varchar(15)          |
| 密码   | 用户的登录密码             | user_password | varchar(30)          |
| 姓名   | 用户的真实姓名             | true_name     | varchar(15)          |
| 性别   | 用户的性别               | gender        | char(2)              |
| 联系方式 | 用户的联系方式，如手机号、电子邮件等  | contact       | varchar(30)          |
| 用户类型 | 用户的类型，如普通用户、酒店管理人员等 | user_type     | int (0表示普通用户 1表示管理员) |

#### 2.房间表 存储酒店房间的基本信息，包括房间类型、房间号、床位数、价格等字段

| 字段名  | 用途                 | 字段名         | 类型          |
|------|--------------------|-------------|-------------|
| 房间id | 房间的唯一标识符           | room_id     | int 自增 主键   |
| 房间类型 | 房间的类型，如单人房、双人房、套房等 | room_type   | varchar(15) |
| 房间号  | 房间的编号              | room_number | int         |
| 床位数  | 房间可容纳的床位数          | beds        | int         |
| 房间价格 | 房间的价格              | room_price  | int         |
| 房间状态 | 房间的入住状态，如空闲、预订、入住等 | room_status | varchar(10) |

#### 3.预订表 存储用户预订房间的信息，包括用户ID、房间ID、预订日期、入住日期、退房日期等字段

| 字段名  | 用途            | 字段名            | 类型          |
|------|---------------|----------------|-------------|
| 预订Id | 预定的唯一标识符      | book_id        | int 自增 主键   |
| 用户Id | 预定房间的用户的唯一标识符 | user_id        | int         |
| 房间Id | 被预定的房间的唯一标识符  | room_id        | int         |
| 预订日期 | 预定房间的日期       | book_date      | datetime    |
| 入住日期 | 预定的房间的入住日期    | check_in_date  | datetime    |
| 退房日期 | 预定的房间的退房日期    | check_out_date | datetime    |
| 预订状态 | 预定的状态，如有效、取消等 | book_status    | varchar(10) |

#### 4.收银表 存储酒店的收入和支出信息，包括项目名称、金额、类型（收入/支出）、日期等字段

| 字段名  | 用途               | 字段名           | 类型           |
|------|------------------|---------------|--------------|
| 收银ID | 收银记录的唯一标识符       | cashier_id    | int 主键 自增    |
| 项目名称 | 收银项目的名称，如房费、餐饮费等 | cashier_item  | varhchar(20) |
| 金额   | 收银的金额            | cashier_price | decimal      |
| 类型   | 收银的类型，如收入，支出等    | cashier_type  | int          |
| 日期   | 收银的日期            | cashier_date  | datetime     |

#### 5.评价表 存储用户对酒店的评价信息，包括用户ID、评分、评价内容、日期等字段

| 字段名  | 用途            | 字段名       | 类型          |
|------|---------------|-----------|-------------|
| 评价ID | 评价的唯一标识符      | e_id      | int 主键 自增   |
| 用户ID | 发表评价的用户的唯一标识符 | user_id   | int         |
| 评分   | 用户对酒店的评分      | score     | int         |
| 评价内容 | 用户对酒店的评价内容    | e_content | varchar(50) |
| 日期   | 评价的日期         | e_date    | datetime    |

### 功能列表
- 登录和注册功能，允许用户创建账号并登录到系统。
- 预订功能，允许用户查询并预订酒店房间。
- 房间管理功能，允许酒店管理人员添加、修改和删除酒店房间信息。
- 收银管理功能，允许酒店管理人员管理收入和支出，并生成报表。(暂未实现)
- 用户评价功能，允许用户对酒店进行评价，并允许酒店管理人员查看和回复评价。
### Api:

| 接口url                     | 接口用途             | 接口方法   |
|:--------------------------|------------------|--------|
| /login                    | 注册接口             | post   |
| /register                 | 登录接口             | post   |
| /user                     | 获取所有用户数据接口       | get    |
| /room                     | 获取所有房间           | get    |
| /room/{roomNumber}        | 获取对应房号的房间        | get    |
| /room/status/{roomStatus} | 获取对应状态的房间        | get    |
| /room                     | 增加房间             | post   |
| /room                     | 修改房间(room_id)    | put    |
| /room                     | 删除房间(room_id)    | delete |
| /reservation              | 获取所有预订           | get    |
| /reservation              | 增加预订             | post   |
| /reservation              | 根据当前时间自动更新所有预订信息 | put    |
| /reservation/done         | 获取所有已经完成的预订信息    | get    |
| /reservation/{id}         | 根据id修改预订的退房日期    | put    |
| /reservation/{id}         | 根据id删除对应的预订      | delete |
| /evaluation               | 获取所有评价           | get    |
| /evaluation               | 添加评价             | post   |
| /evaluation               | 修改评价             | put    |
| /evaluation/{eId}         | 删除评价             | delete |
| /reply                    | 获取所有回复           | get    |
| /reply/{replyId}          | 获取对应回复Id的回复      | get    |
| /reply/e/{eId}            | 获取对于评价Id的回复      | get    |
| /reply                    | 添加回复             | post   |
| /reply                    | 修改回复内容           | put    |
| /reply/{replyId}          | 删除回复             | delete |


