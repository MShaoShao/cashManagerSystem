package com.cash.manager.mapper.bean.type;

/**
 * 订单类型
 *
 * @author MiaoShaoDong
 * @date 15:01 2020/9/18
 */
public enum OrderType {
    /**
     * 单板
     */
    VENEER(0),

    /**
     * 复合板
     */
    COMPOSITE_PLATE(1),
    /**
     * 墙板
     */
    WALL_BOARD(2),
    /**
     * 附件
     */
    ACCESSORIES(3),
    /**
     * 方管
     */
    STEEL_TUBE(4),
    /**
     * 其它
     */
    OTHER(5);


    private static final int VEE = 0;
    private static final int COM = 1;
    private static final int WAL = 2;
    private static final int ACC = 3;
    private static final int TUB = 4;
    private int typeId;

    OrderType(int typeId) {
        this.typeId = typeId;
    }

    public static OrderType getTypeName(int typeId) {
        OrderType orderType = null;
        if (typeId == VEE) {
            orderType = VENEER;
        } else if (typeId == COM) {
            orderType = COMPOSITE_PLATE;
        } else if (typeId == WAL) {

        } else if (typeId == ACC) {
            orderType = ACCESSORIES;
        } else if (typeId == TUB) {
            orderType = STEEL_TUBE;
        } else {
            orderType = OTHER;
        }
        return orderType;
    }

    /**
     * Gets typeId.
     *
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Sets typeId.
     *
     * @param typeId the typeId
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
