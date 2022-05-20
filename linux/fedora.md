# fedora 36

## 下载和安装

到清华镜像站 <https://mirrors.tuna.tsinghua.edu.cn/fedora/releases/36/Workstation/x86_64/iso/>下载最新的镜像和校验文件，校验完成后安装。

```sh
# 校验需要使用git bash

# 先导入fedora的公钥
curl https://getfedora.org/static/fedora.gpg | gpg --import
# 然后检查校验文件的完整性
gpg --verify-files *-CHECKSUM
# 最后再用校验文件校验镜像的完整性
sha256sum -c *-CHECKSUM
```

## 系统美化和配置

首先将系统更新到最新版。

```sh
sudo dnf update
```

安装一些必需的软件包。

```sh
sudo dnf install zsh fish exa starship util-linux-user
```

### sudo 免密码

```sh
echo "$(whoami) ALL=(ALL) NOPASSWD: ALL" | sudo tee "/etc/sudoers.d/$(whoami)"
```

### shell 美化

首先需要启用 root 用户。

```sh
sudo passwd
```

然后在 root 用户下执行以下命令，将 yadm 安装到系统中。

```sh
su

curl -fLo /usr/local/bin/yadm https://github.com/TheLocehiliosan/yadm/raw/master/yadm && chmod a+x /usr/local/bin/yadm
```

然后使用 yadm 克隆我的 dotfiles 项目。

```sh
yadm clone https://github.com/techstay/dotfiles-public.git
```

最后选择 fish 或者 zsh 作为默认 shell。

```sh
chsh -s /usr/bin/fish
chsh -s /bin/zsh
```

### 桌面美化

安装优化工具和一些 gonme 扩展，然后在优化工具中启用。

```sh
sudo dnf install gnome-tweaks gnome-extensions-app \
  gnome-shell-extension-apps-menu \
  gnome-shell-extension-dash-to-dock \
  gnome-shell-extension-user-theme
```

然后安装 numix 主题，并在优化工具中启用。

```sh
sudo dnf install numix-gtk-theme \
   numix-icon-theme
```

如果想要其他好看的主题，可以去 <https://www.gnome-look.org/browse> 寻找，例如[WhiteSur GTK Theme](https://github.com/vinceliuice/WhiteSur-gtk-theme)这个仿苹果主题。

最后的效果如下。

![截图](./img/fedora.png)
