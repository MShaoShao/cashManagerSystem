package com.cash.manager.mapper.bean;

/**
 * @author MiaoShaoDong
 * @date 11:59 2020/9/27
 */
public enum LinkType {
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


    LinkType(int typeId) {
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

    public static LinkType getTypeName(int typeId) {
        LinkType linkType;
        if (typeId == 0) {
            linkType = VENEER;
        } else if (typeId == 1) {
            linkType = COMPOSITE_PLATE;
        } else if (typeId == ACC) {
            linkType = ACCESSORIES;
        } else if (typeId == STEE) {
            linkType = STEEL_TUBE;
        } else {
            linkType = OTHER;
        }

        return linkType;
    }
}
