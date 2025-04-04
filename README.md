# Chat Interface Plugin

这是一个 Jenkins 插件，为 Jenkins 用户提供了一个简单的交互式聊天界面。

## 功能特性

- 简单的聊天界面
- 基于 Jenkins 权限系统的访问控制
- 响应式设计

## 开发环境要求

- Java 11
- Maven 3.6+
- Jenkins 2.440.1

## 构建说明

1. 克隆仓库
2. 运行 `mvn clean package`
3. 生成的 HPI 文件位于 `target/chat-interface-plugin.hpi`

## 安装说明

1. 在 Jenkins 中进入 "Manage Jenkins" > "Manage Plugins"
2. 选择 "Advanced" 标签
3. 在 "Upload Plugin" 部分上传生成的 HPI 文件
4. 重启 Jenkins

## 使用方法

安装后，您可以在 Jenkins 主界面的左侧菜单栏找到 "Chat Interface" 选项。

## 许可证

MIT License 