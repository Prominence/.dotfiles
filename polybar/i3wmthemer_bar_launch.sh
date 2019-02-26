#!/bin/env sh

killall -q polybar

sleep 1;

# if type "xrandr"; then
#   for m in $(xrandr --query | grep " connected" | cut -d" " -f1); do
#     MONITOR=$m polybar i3wmthemer_bar &
#   done
# else
#   polybar i3wmthemer_bar &
# fi

polybar main &
polybar systeminfo &