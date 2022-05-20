# ubuntu 22.04

ubuntu 22.04 是 Ubuntu 最新的长期支持版，这里在虚拟机里安装试用一下，同时做个笔记。

## 下载和安装

使用清华镜像源或者阿里云镜像源下载系统镜像和 SHA256SUMS 文件。

- [清华镜像源](https://mirrors.tuna.tsinghua.edu.cn/ubuntu-releases/22.04/)
- [阿里镜像源](https://mirrors.aliyun.com/ubuntu-releases/22.04/)

下载完成后校验文件的完整性。

```powershell
sha256sum -c SHA256SUMS
```

安装过程略，如果使用 VMware 虚拟机的话，还需要安装虚拟机工具。

```sh
sudo apt install open-vm-tools-desktop
```

## 配置

### sudo 免密码

```sh
echo "$(whoami) ALL=(ALL) NOPASSWD: ALL" | sudo tee "/etc/sudoers.d/$(whoami)"
```

### nala 包管理器

安装 nala 包管理器。

```sh
echo "deb http://deb.volian.org/volian/ scar main" | sudo tee /etc/apt/sources.list.d/volian-archive-scar-unstable.list
wget -qO - https://deb.volian.org/volian/scar.key | sudo tee /etc/apt/trusted.gpg.d/volian-archive-scar-unstable.gpg > /dev/null
```

### 软件源

可以通过软件更新程序来设置软件源，也可以通过命令行方式修改软件源。

```sh
# 备份原来的软件源
sudo mv /etc/apt/sources.list{,.bak}
# 使用阿里云软件源
sudo tee /etc/apt/sources.list <<'EOL'
deb http://mirrors.aliyun.com/ubuntu/ jammy main restricted
deb http://mirrors.aliyun.com/ubuntu/ jammy-updates main restricted
deb http://mirrors.aliyun.com/ubuntu/ jammy universe
deb http://mirrors.aliyun.com/ubuntu/ jammy-updates universe
deb http://mirrors.aliyun.com/ubuntu/ jammy multiverse
deb http://mirrors.aliyun.com/ubuntu/ jammy-updates multiverse
deb http://mirrors.aliyun.com/ubuntu/ jammy-backports main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ jammy-security main restricted
deb http://mirrors.aliyun.com/ubuntu/ jammy-security universe
deb http://mirrors.aliyun.com/ubuntu/ jammy-security multiverse
EOL
```

### bash

先安装 starship，要安装到系统目录的话需要在上面开启 sudo 免密码。

```sh
curl -sS https://starship.rs/install.sh | sh
```

在`~/.bashrc`末尾添加一行。

```sh
tee -a ~/.bashrc <<'EOL'

eval "$(starship init bash)"
EOL
```

### zsh

有代理的话先设置代理，避免网络连接问题。

```sh
export all_proxy=http://192.168.25.1:7890
```

先安装几个必要包。

```sh
sudo nala install zsh git curl exa lua5.4 yadm
```

再安装 zimfw。

```sh
# 通过yadm获取配置文件
yadm clone https://github.com/techstay/dotfiles-public.git
# 下载完配置文件，需要进入zsh完成安装过程
zsh
```

### fish

首先要安装 fish。

```sh
sudo nala install fish
```

然后在配置文件最后添加一行。

```sh
tee -a ~/.config/fish/config.fish <<'EOL'

starship init fish | source
EOL
```

最后再修改一下默认 shell。

```sh
chsh -s /usr/bin/fish
```
