CREATE TABLE t_product
(
    id          BIGINT         NOT NULL PRIMARY KEY COMMENT '主键id',
    `name`      VARCHAR(255)   NOT NULL COMMENT '商品名称',
    price       DECIMAL(15, 2) NOT NULL DEFAULT 0 COMMENT '商品价格',
    create_date DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_date DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    invalid     TINYINT        NOT NULL DEFAULT 0 COMMENT '逻辑删除，0：有效数据；1：无效数据'
) ENGINE = INNODB CHARSET = utf8 COMMENT = '商品信息';


CREATE TABLE t_storage
(
    id          BIGINT   NOT NULL PRIMARY KEY COMMENT '主键id',
    product_id  BIGINT   NOT NULL COMMENT '商品id',
    num         INT      NOT NULL DEFAULT 0 COMMENT '库存数量',
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    invalid     TINYINT  NOT NULL DEFAULT 0 COMMENT '逻辑删除，0：有效数据；1：无效数据'
) ENGINE = INNODB CHARSET = utf8 COMMENT = '库存信息';


CREATE TABLE t_order
(
    id          BIGINT   NOT NULL PRIMARY KEY COMMENT '主键id',
    account_id  BIGINT   NOT NULL COMMENT '用户ID',
    product_id  BIGINT   NOT NULL COMMENT '商品id',
    num         INT      NOT NULL DEFAULT 0 COMMENT '数量',
    state       TINYINT  NOT NULL DEFAULT 0 COMMENT '订单状态，0：下单未支付；1：下单已支付',
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    invalid     TINYINT  NOT NULL DEFAULT 0 COMMENT '逻辑删除，0：有效数据；1：无效数据'
) ENGINE = INNODB CHARSET = utf8 COMMENT = '订单信息';

CREATE TABLE t_account
(
    id           BIGINT         NOT NULL PRIMARY KEY COMMENT '主键id',
    `name`       VARCHAR(36)    NOT NULL COMMENT '姓名',
    cash_balance DECIMAL(15, 2) NOT NULL DEFAULT '0.00' COMMENT '余额',
    create_date  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_date  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    invalid      TINYINT        NOT NULL DEFAULT 0 COMMENT '逻辑删除，0：有效数据；1：无效数据'
) ENGINE = INNODB
  CHARSET = utf8 COMMENT = '账号信息';