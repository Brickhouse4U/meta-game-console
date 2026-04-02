require recipes-core/images/core-image-base.bb

DESCRIPTION = "Game Console Image with Electron launcher"

IMAGE_INSTALL:append = " \
    xserver-xorg \
    xserver-xorg-extension-glx \
    xf86-video-fbdev \
    xinit \
    xrandr \
    matchbox-wm \
    connman \
    connman-client \
    openssh \
    nss \
    atk \
    gtk+3 \
    pango \
    cups \
    i2c-tools \
    ddcutil \
    game-console-menu \
"

IMAGE_FEATURES:append = " \
    ssh-server-openssh \
    debug-tweaks \
"

ROOTFS_POSTPROCESS_COMMAND:append = " setup_autologin;"

setup_autologin() {
    mkdir -p ${IMAGE_ROOTFS}/etc/systemd/system/getty@tty1.service.d
    cat > ${IMAGE_ROOTFS}/etc/systemd/system/getty@tty1.service.d/autologin.conf << AUTOLOGIN
[Service]
ExecStart=
ExecStart=-/sbin/agetty --autologin root --noclear %I \$TERM
AUTOLOGIN
}
