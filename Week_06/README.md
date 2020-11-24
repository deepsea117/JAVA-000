学习笔记

mysql配置重要参数：
max_connections 最大连接数;
query_cache_size 查询缓存;
max_allowed_packet;
innodb_buffer_pool_size;
innodb_thread_concurrency;


mysql命令行参数
mysql -hlocalhost -P3306 -uroot -p密码

docker安装
docker pull mysql

数据库注意定义时间，最好存时间戳
数值精度用bigdecimal
数据库分别存整数和精度

唯一约束本身默认创建索引
