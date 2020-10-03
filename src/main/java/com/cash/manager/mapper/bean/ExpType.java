package com.cash.manager.mapper.bean;

/**
 * 花销类型
 *
 * @author MiaoShaoDong
 * @date 16:20 2020/9/18
 */
public enum ExpType {
    /**
     * 购钢板
     */
    STEEL_VENEER(0),

    /**
     * 购钢管
     */
    STEEL_TUBE(1),
    /**
     * 购泡沫
     */
    FOAM(2),
    /**
     * 其它
     */
    OTHER(3);


    private int typeId;
    ExpType(int typeId) {
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
}
