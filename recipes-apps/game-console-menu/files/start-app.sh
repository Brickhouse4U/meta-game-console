#!/bin/sh
export DISPLAY=:0
export HOME=/root
export DBUS_SESSION_BUS_ADDRESS="unix:path=/run/dbus/system_bus_socket"
exec /opt/game-console-menu/game-console-menu \
    --no-sandbox \
    --disable-gpu \
    --disable-software-rasterizer \
    --disable-gpu-compositing \
    --use-gl=swiftshader \
    --display=:0
