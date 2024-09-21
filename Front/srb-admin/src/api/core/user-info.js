import request from '@/utils/request'

export default {
  getPageList(page, limit, searchObj) {
    return request({
      url: `/admin/core/userInfo/listPage/${page}/${limit}`,
      method: 'get',
      params: searchObj,
      //如果是post
      //method: 'post',
      //data: searchObj,
    })
  },
  lock(id, status) {
    return request({
      url: `/admin/core/userInfo/lock/${id}/${status}`,
      method: 'put',
    })
  },
}
