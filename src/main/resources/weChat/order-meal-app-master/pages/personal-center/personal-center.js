// pages/personal-center/personal-center.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        info:{}
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        this.setData({
            info:wx.getStorageSync('weChatInfo')
        })
        console.log(JSON.stringify(wx.getStorageSync('weChatInfo')))
        console.log('token======' + JSON.stringify(wx.getStorageSync('token')))
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

    returnLogin: function(){
        //清除所有缓存
        wx.clearStorage({
          complete: (res) => {
              console.log(res)
          },
        })
        wx.redirectTo({
            url: '../login/login'
        })
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