#!/bin/sh
# Kill any existing X locks
rm -f /tmp/.X0-lock
rm -f /tmp/.X11-unix/X0

# Start X server in background
X :0 -nolisten tcp &
XPID=$!

# Wait for X to initialize (important — app will fail if X isn't ready)
sleep 3

# Set display
export DISPLAY=:0
export HOME=/root
export DBUS_SESSION_BUS_ADDRESS="unix:path=/run/dbus/system_bus_socket"

# Launch Electron app
/opt/game-console-menu/game-console-menu \
    --no-sandbox \
    --disable-gpu \
    --disable-software-rasterizer \
    --disable-gpu-compositing \
    --use-gl=swiftshader \
    --display=:0

# If app exits, kill X
kill $XPID
