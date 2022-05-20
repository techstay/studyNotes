# 我的学习笔记仓库

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->

[![All Contributors](https://img.shields.io/badge/all_contributors-1-orange.svg?style=flat-square)](#contributors-)

<!-- ALL-CONTRIBUTORS-BADGE:END -->

在线访问 <https://studynote.techstay.life>。

## 目录

- [linux 笔记](linux/README.md)
  - [archlinux 的安装和配置](linux/archlinux.md)
  - [asciinema linux 终端录屏工具](linux/asciinema.md)
  - [fedora](linux/fedora.md)
  - [fish](linux/fish.md)
  - [garuda](linux/garuda.md)，一个界面炫酷的 arch 衍生版
  - [gpg 隐私工具](linux/gpg.md)
  - [nala](linux/nala.md)，高颜值的 apt 替代
  - [ubuntu 22.04 安装笔记](linux/ubuntu22.04.md)
  - [zsh](linux/zsh/README.md)
- [杂项 misc 笔记](misc/README.md)
  - [keepassxc](misc/keepassxc.md)，跨平台的本地密码管理器
  - [gh-cli](misc/gh-cli.md)，github 官方命令行
  - [git 版本控制工具](misc/git.md)
  - [markdown](misc/markdown.md)，一种专注内容的文本格式
  - [Mailspring](misc/Mailspring.md)，一个跨平台的邮件客户端
  - [ventoy 启动盘制作工具](misc/ventoy.md)
  - [vscode](misc/vscode.md)，强大的免费开源编辑器
- [软件资源](software-resources/README.md)
  - [Adobe 系列软件的安装](software-resources/adobe.md)
  - [Mathematica 科学计算软件](software-resources/mathematica.md)
  - [微软 Office](software-resources/msoffice.md)
  - [sublime merge](software-resources/sublime-merge.md)
  - [Visual Studio IDE](software-resources/visual-studio.md)
  - [vmware workstation](software-resources/vmware-workstation.md)
- [windows 笔记](windows/README.md)
  - [开启移动热点](windows/hotspot.md)
  - [windows 系统引导修复](windows/BootRepair.md)
  - [windows 高级终端体验](windows/WindowsTerminalExperience.md)
  - [VHD 双系统安装](windows/VHD-DualBoot.md)
  - [msys2](windows/msys2.md)
  - [openssh](windows/openssh.md)
  - [scoop](windows/scoop.md)，一个 windows 下的软件包管理器
  - [vim 安装笔记](windows/vim.md)
  - [Windows 安装笔记](windows/WindowsInstall.md)
  - [Windows Terminal](windows/WindowsTerminal.md)，Windows 的官方终端
  - [wsl](windows/wsl.md)
- [疑难杂症](troubleshooting/README.md)
  - [tightvnc](troubleshooting/tightvnc.md)
  - [windows](troubleshooting/windows.md)
- [日语笔记](japanese/README.md)

## 写在后面

### 动机

之前我还是很爱写博客的，不过博客散落在 CSDN、简书等好几个地方，到最后我自己都不好管理了。而各种笔记和博客分散在各处，也不利于整理，这一点对于 github 仓库也是一样。既然如此，为什么不把它们合并到一起呢？这也正是本仓库的目的，这个仓库会存放我所有的笔记和学习代码，统一管理，后面我也会逐步将以前的代码整理进来，然后清理不需要的仓库，最后把我的 github 整理成一个干净的状态。

### 项目规范

#### 编码约定

编码和写作的基本原则是方便、简单和统一。每个项目要添加必要的说明，使用读我介绍项目的用途，代码尽量简洁干净，满足可读性。笔记类的文章要简洁易读，这和编写博客类文章还不太一样，博客主要面向大众读者，写作时候要介绍不少基本概念；而笔记主要用来记录一些关键知识，不用做过多介绍，直击主题即可。

#### 开发环境

为了保证多平台的开发环境的一致性，在项目中也要明确指定环境和相关软件的配置，做到跨平台的一致性。

各项目的具体配置在各项目的读我文件中指定。对于 markdown 文件使用 vscode 编辑器来编辑，使用`esbenp.prettier-vscode`扩展来格式化。

其余项目的配置要求在相应的读我文件中说明。

#### git 规范

本项目只是一个笔记仓库，所以这里只采用一个比较简单的分支流程。main 作为主分支，添加新项目的时候在本地建立一个新的 feature 分支并添加代码，提交完毕之后变基到主分支上，然后提交到 Github 上，之后就可以安全的删除 feature 分支了。

gitmoji 是一个提交规范，借由 emoji 表情让 git 提交变得轻松活泼，同时也规定了可以使用的表情防止滥用，不过个人项目嘛，emoji 会使用的更加自由一些。如果你使用 vscode 的话，也可以安装 [gitmoji 扩展](https://marketplace.visualstudio.com/items?itemName=seatonjiang.gitmoji-vscode)，在 git 提交的时候查找和插入表情。

- [😏gitmoji 规范](https://gitmoji.dev)

#### 项目备份

项目除了在 [github](https://github.com/techstay/studyNotes) 上以外，还设置了另外两个推送地址以备份。

- 极狐 gitlab <https://jihulab.com/techstay/studyNotes>
- gitlab <https://gitlab.com/techstay/studyNotes>

```sh
git remote set-url --add origin --push git@jihulab.com:techstay/studyNotes.git
git remote set-url --add origin --push git@gitlab.com:techstay/studyNotes.git
git remote set-url --add origin --push git@github.com:techstay/studyNotes.git
```

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="http://techstay.life"><img src="https://avatars.githubusercontent.com/u/7893448?v=4?s=100" width="100px;" alt=""/><br /><sub><b>techstay</b></sub></a><br /><a href="#example-techstay" title="Examples">💡</a></td>
  </tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
