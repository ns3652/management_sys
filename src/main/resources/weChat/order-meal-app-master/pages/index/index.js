//index.js
//获取应用实例
const app = getApp()
var baseUrl = app.globalData.host;
Page({
    data: {
        restaurantInfo: {
            logo: 'https://tse2-mm.cn.bing.net/th/id/OIP.g01fMwo0SfIiOOasr-P8NAHaGo?w=211&h=183&c=7&o=5&dpr=2&pid=1.7',
            title: '909豪华干饭餐厅',
            memo: '干饭人，干饭魂，干饭人都是人上人！干饭不积极，脑阔有问题！！！',
            image:'https://tse4-mm.cn.bing.net/th/id/OIP.SryMLwWeoR-QRJ2qipImVQHaE7?w=300&h=199&c=7&o=5&dpr=2&pid=1.7',
            address: '恕园2号楼9楼干饭豪华餐厅'
        },
        busineHour: [
            {
                'mealName': '早餐',
                'orderTime': '06:00',
                'refundTime': '06:30'
            }, {
                'mealName': '午餐',
                'orderTime': '10:00',
                'refundTime': '10:30'
            }, {
                'mealName': '晚餐',
                'orderTime': '16:00',
                'refundTime': '16:30'
            }
        ]
    },
    onLoad: function() {
        
    },
    _handlerOrderClick(evt) {
        wx.request({
            url: baseUrl+'/testAuth', 
            data: {
            },
            method: 'get',
            header: {
                "Content-Type":"application/x-www-form-urlencoded", // 默认值
                "Authorization":wx.getStorageSync('token')
            },
            success: function(res) {
                var status = res.data.success
                console.log(res)
                if (status){
                    //跳转到订餐
                    wx.switchTab({ url: '../foods/foods' })
                }else{
                    wx.showToast({
                        title: '没有权限',
                        icon:'none',
                        duration:4000
                    })
                }
            }
          })

        
    },
    getUserInfo: function(e) {
        console.log(e)
        app.globalData.userInfo = e.detail.userInfo
        this.setData({
            userInfo: e.detail.userInfo,
            hasUserInfo: true
        })
    }
})