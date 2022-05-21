# archlinuxgui 笔记

## 下载和安装

[ALG](https://archlinuxgui.in)项目为想要 linux 新用户提供了一个易用的图形化安装界面和与配置系统。如果对 archlinux 不熟悉，又想要尝试这个系统，那么就可以试试 ALG。

官网下载提供了[多个版本](https://archlinuxgui.in/download.html)，推荐选择预配置的桌面环境版，不用像纯净版那样还要自己调整桌面样式，这里我选择了 gnome 版。

安装的时候和普通的 linux 发行版类似，根据图形化安装工具的提示进行即可。不过 ALG 这里有点问题，liveiso 里面貌似没有中文字体，当选择中文的时候全变成了方块，相当尴尬。只能选择英文安装，等到安装完毕之后再自己配置中文环境。

## 配置

sudo 免密码。

```sh
echo "$(whoami) ALL=(ALL) NOPASSWD: ALL" | sudo tee "/etc/sudoers.d/$(whoami)"
```

先安装一些必需的软件。

```sh
sudo pacman -Syu
sudo pacman -S --needed zsh git yadm fish starship reflector \
  exa base-devel ntp iptables-nft wget
```

在 vmware 虚拟机里面使用的还要安装虚拟机工具并启用相关服务。

```sh
sudo pacman -S open-vm-tools-desktop
sudo systemctl enable vmtoolsd.service vmware-vmblock-fuse.service
sudo systemctl start vmtoolsd.service vmware-vmblock-fuse.service
```

### 软件源配置

使用 reflector 测速并选择最快的软件镜像源。

```sh
sudo reflector -c China -n 5 --save /etc/pacman.d/mirrorlist
```

### 启用 paru

```sh
sudo pacman -S --needed base-devel
git clone https://aur.archlinux.org/paru.git
cd paru
makepkg -si
```

### shell 配置

克隆公共 dotfiles。

```sh
yadm clone https://github.com/techstay/dotfiles-public.git
```

然后选择 fish 或 zsh 作为默认 shell。

```sh
chsh -s /usr/bin/fish
```

### 区域和语言

将系统语言设置为中文，如果不起效那么在系统设置里面同样可以更改语言。

```sh
echo 'LANG=zh_CN.UTF-8' | tee ~/.config/locale.conf
```

并安装一些常用字体。

```sh
sudo pacman -S --needed wqy-bitmapfont wqy-microhei wqy-zenhei \
  adobe-source-han-sans-cn-fonts adobe-source-han-sans-jp-fonts \
  adobe-source-han-sans-tw-fonts \
  ttf-sarasa-gothic noto-fonts-cjk noto-fonts-emoji
```

### 字体配置

默认情况下的字体显示一般般，参考 <https://szclsya.me/zh-cn/posts/fonts/linux-config-guide/> 进行字体配置。然后在优化工具中选择`更纱黑体UI`作为主要的界面字体。

```sh
mkdir -p ~/.config/fontconfig
cd ~/.config/fontconfig
wget https://raw.githubusercontent.com/szclsya/dotfiles/master/fontconfig/fonts.conf
```

同时安装 nerd-fonts，让终端字符也能正常显示。

```sh
mkdir -p ~/.local/share/fonts
cd ~/.local/share/fonts
wget https://github.com/ryanoasis/nerd-fonts/releases/download/2.2.0-RC/FantasqueSansMono.zip
unzip -q FantasqueSansMono.zip && rm FantasqueSansMono.zip
fc-cache -f
# AUR
paru -S nerd-fonts-fantasque-sans-mono
```

### 桌面主题

默认的桌面主题其实已经挺不错的了，如果想要修改也可以。个人喜欢安装 dash-to-dock。

```sh
paru -S gnome-shell-extension-dash-to-dock
```

安装完成后在扩展中启用。如果搜索不到可能需要注销并重新登录。

最后的效果如下。

![屏幕截图](https://imgur.com/5gy1xDQ.png)
