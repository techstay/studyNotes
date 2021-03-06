# git

git 是目前最流行的版本控制工具，具有强大的功能。

## 学习

git 官方文档就是一个很好的学习材料，并有电子书[《pro git》](https://git-scm.com/book/zh/v2)可供阅读和下载。

## 开始使用

### 安装

linux 系统直接使用系统的包管理器即可安装。windows 可以自己手动下载安装或者使用`scoop`等包管理器。

- [git for windows](https://git-scm.com/download/win)
- 使用 scoop 包管理器`scoop install git-with-openssh`或者`scoop install git`
  - (两者的区别是`git-with-openssh`带有`ssh-copy-id`等 SSH 相关命令，使用会更方便一些。)

### GUI 软件

以下列举几个个人感觉比较好用的 Git GUI 软件。

- [SourceTree](https://www.sourcetreeapp.com)，中规中矩，因为完全免费所以还是比较不错的
- [GitKraken](https://www.gitkraken.com)，对个人和开源仓库免费，私有仓库需购买商业版
- [Sublime Merge](https://www.sublimemerge.com)，收费软件，但是可以无限试用

### git 配置

git 在使用之前需要配置提交者的名字和电邮。

```sh
git config --global user.name techstay
git config --global user.email lovery521@gmail.com
```

必要的话，还有一些进阶内容可以配置。

```sh
# 默认文本编辑器
git config --global core.editor vim
# 设置gpg签名
git config --global commit.gpgsign true
git config --global tag.gpgsign true
git config --global user.signingkey 3E002217712EBA30A53D485F7CDDF9CBDDF9BF2E
# 设置默认主分支
git config --global init.defaultBranch main
# 自动转换换行符
git config --global core.autocrlf true
# 自动记录和重用
git config --global rerere.enabled true
# 自动递归子模块
git config --global submodule.recurse true
# 拉取代码时使用变基
git config --global pull.rebase true
# 自动改正
git config --global help.autocorrect 30
# 添加查看历史的简写
git config --global alias.l 'log --oneline --decorate --all --graph'
```

### github 配置

如果要在 github 上更加方便的使用 git，还需要一点工作。

首先要在 github 中设置 SSH 公钥，在 powershell 中执行以下命令即可将 SSH 公钥的内容复制到剪贴板中，然后在 github 网页中粘贴。

```powershell
Get-Content $env:USERPROFILE\.ssh\id_ed25519.pub|Set-Clipboard
```

如果使用 gpg 对 git 提交进行签名的话，也可以将 gpg 公钥告知 github，这样在网页端也可以显示验证状态。然后在 powershell 中执行下面的命令（注意将邮箱换成自己 gpg 密钥的邮箱）将公钥的内容复制到剪贴板，之后在 github 中粘贴即可。

```powershell
gpg -a --export lovery521@gmail.com|Set-Clipboard
```

### 防止闪屏

git bash 输入命令时可能会出现终端屏幕闪烁的问题，可以通过编辑`~/.inputrc`文件，并添加`set bell-style none`的方式来解决。

## cheatsheet

git 操作比较复杂，这里将一些常用的命令列举出来，方便查阅。

```sh
<!-- -------------------------------- 初始化仓库 -------------------------------- -->
# 在当前目录初始化git仓库
git init
# 克隆仓库
git clone <url>
# 克隆仓库并初始化所有子模块
git clone --recurse-submodules <url>

<!-- -------------------------------- 添加和提交 -------------------------------- -->
# 添加一个文件到暂存区
git add <file>
# 把所有文件改动添加到暂存区
git add .
# 取消文件的暂存
git reset HEAD <file>
# 丢弃对文件的改动，无法恢复
git checkout -- <file>
# 提交所有暂存区的文件
git commit
# 提交并输入简短的信息
git commit -m 'msg'
# 追加最后一次提交
git commit --ammend
# 追加最后一次提交，保持提交信息不变
git commit --ammend --no-edit
# 提交时自动添加所有已追踪文件的改动
git commit -a
# 列出所有可清除的空目录、忽略的目录和未跟踪的文件
git clean -xfdn
# 清除所有空目录、忽略的目录和未跟踪的文件，不可恢复
git clean -xfd

<!-- ------------------------------- 查看历史和差异 ------------------------------- -->
# 查看状态
git status
# 查看差异
git diff
# 查看历史
git log
# 查看历史时同时查看补丁
git log -p
# 以单行方式查看历史
git log --oneline
# 以图形方式查看历史
git log --oneline --graph
# 按时间、提交者、提交信息、数量过滤提交
git log --after 1.weeks --before 2.days --author techstay --grep scoop -5 --oneline
# 按添加或删除匹配匹配字符串来过滤提交
git log -S <content>
# 只显示指定路径的提交，该参数必须放到最后面
git log -- <path>
# 查看在主题分支不在基础分支中的提交
git log <basebranch>..<topicbranch>
# 查看在主题分支不在基础分支中的提交，可以查询多个分支
git log ^<basebranch> <topicbranch>
# 查看两个分支所有不公有的提交
git log <b1>...<b2> --left-right
# 查看操作历史
git reflog
# 查看代码的首次提交者
git blame -L 1,20 -C README.md

<!-- -------------------------------- 推送和拉取 -------------------------------- -->
# 查看当前的远程仓库设置
git remote -v
# 添加新的远程仓库设置
git remote add origin <url>
# 删除远程仓库
git remote rmeove origin
# 编辑新的远程仓库URL设置
git remote set-url --add --push origin <url>
# 推送并跟踪分支
git push -u origin main
# 获取远程更新
git fetch
# 拉取更新到本地
git pull

<!-- --------------------------------- 分支 ---------------------------------- -->
# 查看分支
git branch -v
# 新建分支
git branch <branch>
# 新建并切换到新分支
git checkout -b <branch>
# 检出分支
git checkout <branch>
# 删除分支
git branch -d <branch>
# 强制删除分支，任何未合并的改动将丢失
git branch -D <branch>
# 将制定分支合并到当前分支
git merge <branch>
# 让当前分支跟踪远程分支
git branch -u origin/main
# 删除远程分支
git push --delete <branch>
# 删除远程仓库已删除的远程分支引用
git fetch --prune <branch>
# 将当前分支变基到指定分支
git rebase <branch>
# 将主题分支变基到基础分支上
git rebase <basebranch> <topicbranch>
# 将在b2中不在b1中的提交变基到基础提交上
git rebase --onto <basebranch> <branch1> <branch2>
# 交互式变基，可以执行很多高级操作
git rebase -i HEAD~5
# 拣选
git cherry-pick

<!-- --------------------------------- 贮藏 ---------------------------------- -->
# 将当前改动存储到贮藏栈上
git stash
# 贮藏时包括未跟踪的文件
git stash --include-untracked
# 贮藏时添加简短信息
git stash -m 'msg'
# 列出贮藏
git stash list
# 应用贮藏并恢复暂存的文件
git stash --index
# 从贮藏创建新分支
git stash branch <branchname>
# 应用贮藏并从栈上移除
git stash pop
# 直接删除贮藏
git stash drop
# 也可以对非栈顶的贮藏进行操作，例如删除
git stash drop 'stash@{1}'

<!-- --------------------------------- 标签 ---------------------------------- -->
# 列出标签
git tag
# 通配符查询
git tag -l 'v1*'
# 为某次提交打标签
git tag -a 'v1.0' -m 'v1.0' <hash>
# 将标签推送到远程仓库
git push --tags
# 删除本地标签
git tag -d <tagname>
# 删除远程标签
git push origin --delete <tagname>
```
