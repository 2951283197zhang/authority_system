/*
 Navicat Premium Data Transfer

 Source Server         : mysqlDJ002
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : authority_system

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 13/10/2020 10:23:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级id。0：表示顶级目录',
  `menu_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_type` int(1) NOT NULL COMMENT '菜单类型。1：顶级目录；2：菜单;3：按钮',
  `menu_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '当前菜单对应的图标样式',
  `permiss` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限标识符',
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '点击菜单要跳转的路径地址',
  `function_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打开跳转地址后对应菜单的图标样式',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `seq` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按钮的顺序。从1，2，3开始',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('06dc37fa15024d93bb3e9641a3f733da', '0', '系统管理', 1, 'icon-setup', 'system', '', '', '2019-01-16 15:31:40', '2019-01-16 18:33:06', NULL);
INSERT INTO `t_menu` VALUES ('2', '06dc37fa15024d93bb3e9641a3f733da', '用户管理', 2, 'icon-people', 'user:list', 'a/user/listPage', '', '2019-01-16 15:31:40', '2019-01-16 18:39:23', NULL);
INSERT INTO `t_menu` VALUES ('3d78c2804d5043e9a5011a8661873f23', '8a0f548bb58540d68d444a6fc3924803', '删除', 3, 'icon-empty', 'role:delete', 'a/role/delete', 'layui-btn-danger bt_delete', '2019-01-16 15:31:40', '2019-01-17 13:44:55', '3');
INSERT INTO `t_menu` VALUES ('451a231d26104452a04716a2ce763cdf', '2', '新增', 3, 'icon-add', 'user:add', 'admin/user/user_addPage', 'bt_add', '2019-01-16 15:31:40', '2019-01-17 12:43:54', '1');
INSERT INTO `t_menu` VALUES ('5cb32e33fc824158aa0a36ee3612fc0a', '2', '分配角色', 3, 'icon-addpeople', 'user:setRole', 'admin/user/user_setRolePage', 'layui-btn-normal bt_setRole', '2019-01-16 15:31:40', '2019-01-17 12:43:04', '4');
INSERT INTO `t_menu` VALUES ('6b53b4d4485342bd8552be495c51d1b1', 'd0538d09f65a47fdafe6c6a86e64a50d', '删除', 3, 'icon-empty', 'menu:delete', 'a/menu/delete', 'layui-btn-danger bt_delete', '2019-01-16 15:31:40', '2019-01-17 13:45:09', '3');
INSERT INTO `t_menu` VALUES ('8a0f548bb58540d68d444a6fc3924803', '06dc37fa15024d93bb3e9641a3f733da', '角色管理', 2, 'icon-group_fill', 'role:list', 'a/role/listPage', '', '2019-01-16 15:31:40', '2019-01-16 18:24:03', NULL);
INSERT INTO `t_menu` VALUES ('8b0b88fa33f54770b4f5647fd5948eb6', '8a0f548bb58540d68d444a6fc3924803', '权限分配', 3, 'icon-addpeople_fill', 'role:setMenu', 'admin/role/role_setMenuPage', 'layui-btn-normal bt_setMenu', '2019-01-16 15:31:40', '2019-01-17 12:47:58', '4');
INSERT INTO `t_menu` VALUES ('cb839aa124294b2b919c15385cd022c3', '8a0f548bb58540d68d444a6fc3924803', '修改', 3, 'icon-brush', 'role:update', 'a/role/updatePage', 'layui-btn-warm bt_update', '2019-01-16 15:31:40', '2019-01-17 13:42:22', '2');
INSERT INTO `t_menu` VALUES ('cbf9f9189fa34bc7a5d20fd012067419', 'd0538d09f65a47fdafe6c6a86e64a50d', '修改', 3, 'icon-brush', 'menu:update', 'a/menu/updatePage', 'layui-btn-warm bt_update', '2019-01-16 15:31:40', '2019-01-17 13:42:31', '2');
INSERT INTO `t_menu` VALUES ('d0538d09f65a47fdafe6c6a86e64a50d', '06dc37fa15024d93bb3e9641a3f733da', '菜单管理', 2, 'icon-createtask', 'menu:list', 'a/menu/listPage', '', '2019-01-16 15:31:40', '2019-01-16 18:25:07', NULL);
INSERT INTO `t_menu` VALUES ('e2e95743ca034db09c0b4e70d9c5f78f', '2', '修改', 3, 'icon-brush', 'user:update', 'a/user/updatePage', 'layui-btn-warm bt_update', '2019-01-16 15:31:40', '2019-01-17 13:42:14', '2');
INSERT INTO `t_menu` VALUES ('eb9cbadb9bff4788af5d229ef3b393db', '8a0f548bb58540d68d444a6fc3924803', '新增', 3, 'icon-add', 'role:add', 'admin/role/role_addPage', 'bt_add', '2019-01-16 15:31:40', '2019-01-17 12:44:21', '1');
INSERT INTO `t_menu` VALUES ('ec42e98fe9a046e3a64147b47d6a3d2b', 'd0538d09f65a47fdafe6c6a86e64a50d', '新增', 3, 'icon-add', 'menu:add', 'a/menu/addPage', 'bt_add', '2019-01-16 15:31:40', '2019-01-17 12:58:13', '1');
INSERT INTO `t_menu` VALUES ('ef86649fa75343f08990bff6b40042d2', '2', '删除', 3, 'icon-empty', 'user:delete', 'a/user/delete', 'layui-btn-danger bt_delete', '2019-01-17 13:44:01', '2019-01-17 13:44:34', '3');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('4ce5aa1bcfb14bf581e97f20484bb4b4', '345认同与222', '234t', '2020-10-09 14:14:19', '2020-10-10 15:39:03');
INSERT INTO `t_role` VALUES ('5dc856909dc645eaa60eb2258b881e0e', 'vip_demaino2', '钻石会员2', '2020-10-09 13:21:43', '2020-10-09 14:03:00');
INSERT INTO `t_role` VALUES ('8c4bfc4a44504d41aaec3f4846e5eb68', 'vip_userList_userAdd', 'shitou123用户权限验证', '2020-10-12 09:28:17', NULL);
INSERT INTO `t_role` VALUES ('c1bdd44de2534bedab5723e46155b36b', 'vip1', '权限测试角色1', '2020-10-10 10:01:59', NULL);
INSERT INTO `t_role` VALUES ('de940380880348afa4c3a7be058b2b31', 'vip_user', '会员用户', '2020-09-28 09:10:58', NULL);
INSERT INTO `t_role` VALUES ('e7ac69d8bfec42b68d78ef49eb6e5756', 'tyhj', 'fgh', '2020-10-09 13:27:33', NULL);
INSERT INTO `t_role` VALUES ('e7b5123189684533bddfa842f81c1f0d', 'root', 'root', '2019-01-16 15:33:08', '2019-01-16 15:32:23');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单id',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (24, '06dc37fa15024d93bb3e9641a3f733da', 'de940380880348afa4c3a7be058b2b31');
INSERT INTO `t_role_menu` VALUES (25, '2', 'de940380880348afa4c3a7be058b2b31');
INSERT INTO `t_role_menu` VALUES (26, '451a231d26104452a04716a2ce763cdf', 'de940380880348afa4c3a7be058b2b31');
INSERT INTO `t_role_menu` VALUES (27, '06dc37fa15024d93bb3e9641a3f733da', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (28, '2', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (29, '451a231d26104452a04716a2ce763cdf', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (30, 'e2e95743ca034db09c0b4e70d9c5f78f', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (31, '5cb32e33fc824158aa0a36ee3612fc0a', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (32, '8a0f548bb58540d68d444a6fc3924803', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (33, 'eb9cbadb9bff4788af5d229ef3b393db', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (34, 'cb839aa124294b2b919c15385cd022c3', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (35, '3d78c2804d5043e9a5011a8661873f23', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (36, '8b0b88fa33f54770b4f5647fd5948eb6', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (37, 'd0538d09f65a47fdafe6c6a86e64a50d', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (38, 'ec42e98fe9a046e3a64147b47d6a3d2b', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (39, 'cbf9f9189fa34bc7a5d20fd012067419', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (40, '6b53b4d4485342bd8552be495c51d1b1', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (41, '7f51ee7deac041f69d4d145b4666cc07', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (42, '90f8e1728a86440b9bf436edbfa8b515', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_role_menu` VALUES (43, '2', 'c1bdd44de2534bedab5723e46155b36b');
INSERT INTO `t_role_menu` VALUES (44, '451a231d26104452a04716a2ce763cdf', 'c1bdd44de2534bedab5723e46155b36b');
INSERT INTO `t_role_menu` VALUES (45, 'e2e95743ca034db09c0b4e70d9c5f78f', 'c1bdd44de2534bedab5723e46155b36b');
INSERT INTO `t_role_menu` VALUES (46, 'ef86649fa75343f08990bff6b40042d2', 'c1bdd44de2534bedab5723e46155b36b');
INSERT INTO `t_role_menu` VALUES (47, '5cb32e33fc824158aa0a36ee3612fc0a', 'c1bdd44de2534bedab5723e46155b36b');
INSERT INTO `t_role_menu` VALUES (48, '2', '8c4bfc4a44504d41aaec3f4846e5eb68');
INSERT INTO `t_role_menu` VALUES (49, '451a231d26104452a04716a2ce763cdf', '8c4bfc4a44504d41aaec3f4846e5eb68');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `nickname` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `user_img` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `sex` int(1) NOT NULL COMMENT '性别：1、男；-1、女',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态：on、可用；其它、禁用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('81cca37cb50c4385b74a933410909950', 'root', 'e010a01273a19025e3aa62c9099353bf', '9d0743c9a7e245dd85ff87544cbccb08', 'root', '', '17688561711', 1, '123@qq.com', 'on', '2019-01-17 12:48:46', NULL);
INSERT INTO `t_user` VALUES ('9dde96c997894968bb1ebbbc90aa1ccc', 'shitou123', 'bcc86bfee7042ee879b05ae0261e08e2', 'a2516268f38d4285a6b6cb3019041dc5', '用户授权测试', NULL, '13756786801', 1, '345676543@qq.com', 'on', '2020-10-12 08:47:34', NULL);
INSERT INTO `t_user` VALUES ('a49b8547cda342deb439b489f4643ef8', '凯特', '123456', 'd222ceaad40e4ea99e47a6b55545b631', 'kitty2', NULL, '13717534430', 1, '287874422@qq.com', 'on', '2020-10-09 09:44:47', '2020-10-09 10:05:20');
INSERT INTO `t_user` VALUES ('add41fe3a3aa4f32a35b33ba6b3a0c56', 'shitou', '4fefb1f57301d09548b0ebe6eaeebcaf', 'e8c142b3557d4d8387fcc3af7abe7342', '石头', NULL, '13447556650', 1, '34567843@qq.com', 'on', '2020-10-10 16:03:44', NULL);
INSERT INTO `t_user` VALUES ('de769a317e6543cab825ca5053acb8ab', 'tom', '41d3c0b23af92a993722d138ea44fc5a', 'cbedee022be74cb3a0e67b28be3d7e62', 'dasd', '', '137173242', -1, '12211233@qq.com', 'on', '2020-09-28 14:41:22', NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, '81cca37cb50c4385b74a933410909950', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_user_role` VALUES (4, '1026027802194242a4adb367b2780e46', 'de940380880348afa4c3a7be058b2b31');
INSERT INTO `t_user_role` VALUES (5, '1026027802194242a4adb367b2780e46', 'e7b5123189684533bddfa842f81c1f0d');
INSERT INTO `t_user_role` VALUES (7, '1e8f0d96340244bb9c07985fe34e58be', '4ce5aa1bcfb14bf581e97f20484bb4b4');
INSERT INTO `t_user_role` VALUES (8, '1e8f0d96340244bb9c07985fe34e58be', '5dc856909dc645eaa60eb2258b881e0e');
INSERT INTO `t_user_role` VALUES (10, '9dde96c997894968bb1ebbbc90aa1ccc', '8c4bfc4a44504d41aaec3f4846e5eb68');

SET FOREIGN_KEY_CHECKS = 1;
