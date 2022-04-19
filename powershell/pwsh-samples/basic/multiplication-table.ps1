# ------------------------------------------------------------------------------
# 打印九九乘法表
# ------------------------------------------------------------------------------

foreach ($a in 1..9) {
  foreach ($b in 1..$a) {
    Write-Host -NoNewline "${b}X$a=$($a*$b)`t"
  }
  Write-Host
}