Page({

    /**
     * 页面的初始数据
     */
    data: {
        orderList: [
            {
                'orderNumber': '200310000003',
                'orderTime': '2020-03-10 15:30:50',
                'paymentType': '微信支付',
                'orderTotal': '96.80',
                'orderStatus': '已完成',
                'refundTotal': '56.80',
                'refundList': [
                    {
                        'refundNumber': '200310000003-01',
                        'refundTime': '2020-03-10 16:30:50',
                        'refundSubtotal': '20.80'
                    }, {
                        'refundNumber': '200310000003-02',
                        'refundTime': '2020-03-10 18:10:30',
                        'refundSubtotal': '36.00'
                    }
                ]
            }, {
                'orderNumber': '200310000002',
                'orderTime': '2020-03-10 09:36:56',
                'paymentType': '余额支付',
                'orderTotal': '56.80',
                'orderStatus': '待送餐',
                'refundTotal': '0.00',
                'refundList': []
            }, {
                'orderNumber': '200310000001',
                'orderTime': '2020-03-09 17:36:56',
                'paymentType': '微信支付',
                'orderTotal': '106.80',
                'orderStatus': '已完成',
                'refundTotal': '0.00',
                'refundList': []
            }
        ]

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        console.log(this.data.orderLists);
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})