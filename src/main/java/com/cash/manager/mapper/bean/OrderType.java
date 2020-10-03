package com.cash.manager.mapper.bean;

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
     * 辅件
     */
    ACCESSORIES(2),
    /**
     * 钢管
     */
    STEEL_TUBE(3),
    /**
     * 其它
     */
    OTHER(4);


    private static final int ACC = 2;
    private static final int STEE = 3;
    private int typeId;

    OrderType(int typeId) {
        this.typeId = typeId;
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

    public static OrderType getTypeName(int typeId) {
        OrderType orderType;
        if (typeId == 0) {
            orderType = VENEER;
        } else if (typeId == 1) {
            orderType = COMPOSITE_PLATE;
        } else if (typeId == ACC) {
            orderType = ACCESSORIES;
        } else if (typeId == STEE) {
            orderType = STEEL_TUBE;
        } else {
            orderType = OTHER;
        }

        return orderType;
    }
}
