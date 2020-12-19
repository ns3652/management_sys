// pages/nutrition/nutrition.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
  
    },
  
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
      // 获取设备相关的信息
      var systemInfo = wx.getSystemInfoSync();
      var windowWidth = systemInfo.windowWidth;
      var windowHeight = systemInfo.windowHeight;
      var boxWidth = windowWidth;
      var boxHeight = 100;
      var radius = boxHeight / 2 + (boxWidth * boxWidth) / (8 * boxHeight);
      var left = -radius + boxWidth / 2;
      this.setData({
        windowWidth: windowWidth,
        windowHeight: windowHeight,
        radius: radius,
        left: left
      });
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